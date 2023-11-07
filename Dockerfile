FROM openjdk:11-jre-slim
EXPOSE 8089
COPY target/devops-integration.jar devops-integration.jar
CMD ["java", "-jar", "devops-integration.jar"]
