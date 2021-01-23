# Docker Memory Test
##### Docker Memory Test is a Java Application for test memory inside a Docker container
## Installation
##### Use Maven command to build a jar file and to create a docker image:
```bash
mvn clean package
```
## Usage
###### simple run image:
```bash
docker run java-centos-mem
```
###### or run with memory and CPUs limitations:
```bash
docker run --memory=100m --memory-swap=100m --cpus 2 java-centos-mem
```

###### Show how memory usage increases:
```bash
docker stats
```

## For example

###### With JVM parameters in the Dockerfile:
``
-XX:+UseContainerSupport -Xmx10g -Xms10g
``
###### type in bash:

```bash
docker run --memory=100m --memory-swap=100m --cpus 2 java-centos-mem
```
###### output:
```bash

System resources available to the JVM
Total available processors(CPUs): 2
Total available memory: 100 mb
Total used memory: 9898 mb
Maximum reserved memory: 9898 mb
Free memory: 9680 mb

Total system processors(CPUs): 6
Total system memory: 16007 mb
Total system used memory: 5379 mb
Total system free memory: 5131 mb
Total system shared memory: 191 mb
Total system buff/cache memory: 5496 mb
Total system available memory: 10132 mb
Total system swap: 2046 mb
Total system used swap: 0 mb
Total system free swap: 2046 mb
Total system shared swap: 0 mb
Total system buff/cache swap: 0 mb
Total system available swap: 0 mb
File system root: /
Total space: 184 gb
Free space: 169500 mb
Usable space: 159836 mb 
```
```bash
docker stats
```
```bash

CONTAINER ID   NAME              CPU %     MEM USAGE / LIMIT   MEM %     NET I/O      BLOCK I/O   PIDS
0fe0b7a59fe7   objective_brown   4.87%     55.09MiB / 100MiB   55.09%    2.8kB / 0B   0B / 0B     16
```

