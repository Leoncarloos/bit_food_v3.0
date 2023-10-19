FROM amazoncorretto:17
MAINTAINER CL
COPY target/bitfood-0.0.1-SNAPSHOT.jar bitfood.jar
ENTRYPOINT ["java","-jar", "/bitfood.jar"]
