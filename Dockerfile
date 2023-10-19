FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY ./target/bitfood-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV DB_URL=jdbc:postgresql://localhost:5432/BitFood
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=170603
RUN apt-get update && apt-get install -y postgresql-client
CMD ["java", "-jar", "app.jar"]
