# docker stop $(docker ps -a -q)
# docker rm $(docker ps -a -q)
# docker rmi $(docker images -a -q)
# docker images -a
# docker ps -a
# docker run --memory=100m --memory-swap=100m --cpus 2 java-centos-mem


#FROM bellsoft/liberica-openjdk-centos:11.0.9.1
FROM bellsoft/liberica-openjdk-centos:latest

ENV WORK_DIR /usr/src/memapp
WORKDIR $WORK_DIR
COPY ./memoryTestApp.jar memoryTestApp.jar
#CMD java -jar memoryTestApp.jar
#CMD java -XX:+UseContainerSupport -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1026 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -jar memoryTestApp.jar
#CMD java -XX:-UseContainerSupport -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1026 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -jar memoryTestApp.jar
CMD java -XX:+UseContainerSupport -Xmx10g -Xms10g -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1026 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -jar memoryTestApp.jar
# docker stats
# sudo dmesg -T
# sudo apt-get install lxcfs
# sudo systemctl enable lxcfs.service
# docker run --memory=100m --memory-swap=100m --cpus 2 -it -v /var/lib/lxcfs/proc/meminfo:/proc/meminfo java-centos-mem
