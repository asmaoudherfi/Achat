# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim
COPY target/achat-1.0.jar app.jar
EXPOSE 8089
CMD ["java", "-jar", "app.jar"]