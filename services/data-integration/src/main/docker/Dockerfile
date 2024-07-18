# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy
RUN mkdir /twinficient
WORKDIR /twinficient

COPY target/data-integration-0.0.2-SNAPSHOT-jar-with-dependencies.jar /twinficient/data-integration.jar

ENTRYPOINT [ "java" ]
CMD [ "-jar", "data-integration.jar"]