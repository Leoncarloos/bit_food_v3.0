FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/bitfood-0.0.1-SNAPSHOT.jar bitfood.jar
EXPOSE 8080
ENV DB_URL=jdbc:postgresql://localhost:5432/BitFood
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=170603
CMD ["java", "-jar", "bitfood.jar"]
