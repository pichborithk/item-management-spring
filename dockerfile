FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/ItemManagement-1.0.0.jar app.jar

EXPOSE 1337

ENTRYPOINT ["java", "-jar", "app.jar"]