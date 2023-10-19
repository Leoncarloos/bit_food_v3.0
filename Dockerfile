FROM openjdk:17.0.1-jdk-slim
COPY target/bitfood-0.0.1-SNAPSHOT.jar bitfood.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bitfood.jar"]
