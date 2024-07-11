#Dockerfile for Java Spring application with PostgreSQL database

# Use an OpenJDK runtime as base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container at path /app
COPY target/catalogo-0.0.1-SNAPSHOT.jar /app/target/catalogo-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application uses (default is 8080)
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "/app/target/catalogo-0.0.1-SNAPSHOT.jar"]
