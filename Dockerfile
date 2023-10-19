FROM maven:3.9.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/bitfood-0.0.1-SNAPSHOT.jar bitfood.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bitfood.jar"]