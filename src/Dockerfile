#FROM alpine
#FROM openjdk:11-jdk-slim
#FROM cakhanif/openjdk11-centos
FROM liberica-openjdk-alpine:11.0.9.1
ENV WORK_DIR /usr/src/memapp
WORKDIR $WORK_DIR
#COPY com /usr/src/memapp/com
COPY ./memoryTestApp.jar memoryTestApp.jar
#RUN apk add openjdk8
#ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
#ENV PATH $PATH:$JAVA_HOME/bin

#RUN echo $PATH

RUN cd com/kirilo/memory/ && javac *.java

ENTRYPOINT java com/kirilo/memory/MemoryTest
#CMD ["java", "MemoryTest"]
