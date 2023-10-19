FROM amazoncorretto:17
LABEL maintainer="CL"
COPY bitfood-0.0.1-SNAPSHOT.jar bitfood.jar
ENTRYPOINT ["java","-jar", "/bitfood.jar"]
