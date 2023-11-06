FROM openjdk:11-jre-slim
EXPOSE 8089
WORKDIR /Achat
COPY target/devops-integration.jar /Achat/devops-integration.jar
CMD ["java", "-jar", "devops-integration.jar"]
