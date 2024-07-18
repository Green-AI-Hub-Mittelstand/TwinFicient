#!/bin/bash

./mvnw clean package

mkdir -p ../docker/data/digital-twin-initializer/target
cp -v digital-twin-initializer/target/docker/twinficient/digital-twin-initializer/build/Dockerfile ../docker/data/digital-twin-initializer
cp -v digital-twin-initializer/target/digital-twin-initializer-0.0.7-SNAPSHOT-jar-with-dependencies.jar ../docker/data/digital-twin-initializer/target/digital-twin-initializer-0.0.7-SNAPSHOT-jar-with-dependencies.jar

mkdir -p ../docker/data/data-integration/target
cp -v data-integration/target/docker/twinficient/data-integration/build/Dockerfile ../docker/data/data-integration
cp -v data-integration/target/data-integration-0.0.2-SNAPSHOT-jar-with-dependencies.jar ../docker/data/data-integration/target/data-integration-0.0.2-SNAPSHOT-jar-with-dependencies.jar