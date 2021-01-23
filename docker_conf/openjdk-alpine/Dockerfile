#FROM bellsoft/liberica-openjdk-alpine:11.0.9.1
FROM bellsoft/liberica-openjdk-alpine:latest

ENV WORK_DIR /usr/src/memapp
WORKDIR $WORK_DIR

COPY ./memoryTestApp.jar memoryTestApp.jar
CMD java -jar memoryTestApp.jar
