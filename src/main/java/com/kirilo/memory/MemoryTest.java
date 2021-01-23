package com.kirilo.memory;

import com.sun.management.OperatingSystemMXBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// https://stackoverflow.com/questions/12807797/java-get-available-memory/59551787#59551787


public class MemoryTest {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("System resources available to the JVM");
        /* Total number of processors or cores available to the JVM */
        System.out.printf("Total available processors(CPUs): %d%n", runtime.availableProcessors());

        OperatingSystemMXBean osMBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.printf("Total available memory: %d mb%n", osMBean.getTotalPhysicalMemorySize() / 1024 / 1024);

        /* Total memory currently in use by the JVM */
        System.out.printf("Total used memory: %d mb%n", runtime.totalMemory() / 1024 / 1024);
        /* Maximum amount of memory the JVM will attempt to use */
        System.out.printf("Maximum reserved memory: %d mb%n", runtime.maxMemory() / 1024 / 1024);
        /* Total amount of free memory available to the JVM */
        System.out.printf("Free memory: %d mb%n%n", runtime.freeMemory() / 1024 / 1024);

        /* Only for Linux */
        try {
            linuxCPUsInfo(runtime);
            linuxMemInfo(runtime);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            System.out.println("File system root: " + root.getAbsolutePath());
            System.out.printf("Total space: %d gb %n", root.getTotalSpace() / 1024 / 1024 / 1024);
            System.out.printf("Free space: %d mb %n", root.getFreeSpace() / 1024 / 1024);
            System.out.printf("Usable space: %d mb %n", root.getUsableSpace() / 1024 / 1024);
        }

        List<Long> list = new ArrayList<>();
        for (long idx = 0; idx < Long.MAX_VALUE; idx++) {
            Thread.sleep(1);
            list.add(System.currentTimeMillis());
            list.add(System.currentTimeMillis());
            list.add(System.currentTimeMillis());
        }
        System.out.println(list.size());
    }

    /* https://stackoverflow.com/a/6441483/9586230 */
    private static void linuxMemInfo(Runtime runtime) throws Exception{
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(runtime.exec("free -m").getInputStream())
        )) {
            int index = 0;
            br.readLine();
            while (index++ < 2 && (br.ready())) {
                printMemInfo(index, br.readLine().split("\\s+"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void linuxCPUsInfo(Runtime runtime) throws Exception{
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(runtime.exec("nproc --all").getInputStream())
        )) {
            while (br.ready()) {
                System.out.printf("Total system processors(CPUs): %s%n", br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printMemInfo(int index, String... memArr) {
        String[] memInfo = Arrays.copyOf(memArr, 7);
        String arg = index == 1 ? "memory" : "swap";
        System.out.printf("Total system %s: %d mb %n", arg, Integer.parseInt(Optional.ofNullable(memInfo[1]).orElse("0")));
        System.out.printf("Total system used %s: %d mb %n", arg, Integer.parseInt(Optional.ofNullable(memInfo[2]).orElse("0")));
        System.out.printf("Total system free %s: %d mb %n", arg, Integer.parseInt(Optional.ofNullable(memInfo[3]).orElse("0")));
        System.out.printf("Total system shared %s: %d mb %n", arg, Integer.parseInt(Optional.ofNullable(memInfo[4]).orElse("0")));
        System.out.printf("Total system buff/cache %s: %d mb %n", arg, Integer.parseInt(Optional.ofNullable(memInfo[5]).orElse("0")));
        System.out.printf("Total system available %s: %d mb %n", arg, Integer.parseInt(Optional.ofNullable(memInfo[6]).orElse("0")));
    }
}
