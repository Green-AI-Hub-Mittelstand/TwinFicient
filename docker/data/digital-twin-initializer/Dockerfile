# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy
RUN mkdir /twinficient
WORKDIR /twinficient

COPY target/digital-twin-initializer-0.0.7-SNAPSHOT-jar-with-dependencies.jar /twinficient/digital-twin-initializer.jar

ENV TF_CONFIG_FOLDER=/twinficient/config
ENV TF_AAS_REPO_ADDRESS=http://127.0.0.1:8081
ENV TF_SM_REPO_ADDRESS=http://127.0.0.1:8081

ENTRYPOINT [ "java" ]
CMD [ "-jar", "digital-twin-initializer.jar"]
