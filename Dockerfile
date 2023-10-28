# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim
# Copy the Spring Boot JAR file into the container
COPY target/app.jar.jar app.jar
# Expose the port that the Spring Boot application will listen on
EXPOSE 8089
# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]