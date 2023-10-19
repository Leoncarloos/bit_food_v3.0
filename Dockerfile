FROM maven:3.8.5-openjdk-17
MAINTAINER CARLOS LEON
COPY target/bitfood-0.0.1-SNAPSHOT.jar bitfood.jar
ENTRYPOINT ["java","-jar","bitfood.jar"]