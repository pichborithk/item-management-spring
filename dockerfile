
# Build image with only jar file (need to build with maven first)

# FROM openjdk:17-jdk-slim
# WORKDIR /app
# COPY target/ItemManagement-1.0.0.jar app.jar
# EXPOSE 1337
# ENTRYPOINT ["java", "-jar", "app.jar"]

# -----------------------------------------------------------------------

# Build images include maven (no need to build with maven before hand) **smallest size image

FROM maven:3.8.5-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build target/ItemManagement-1.0.0.jar app.jar
EXPOSE 1337
ENTRYPOINT ["java", "-jar", "app.jar"]

# -----------------------------------------------------------------------

# Build image with maven and run directly from maven image
# FROM maven:3.8.5-openjdk-17-slim
# WORKDIR /app
# COPY . .
# EXPOSE 1337
# RUN mvn clean package -DskipTests
# CMD ["mvn", "spring-boot:run"]