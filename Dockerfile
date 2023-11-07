FROM openjdk:8
EXPOSE 8089
WORKDIR /Achat
COPY target/devops-integration.jar /Achat/
CMD ["java", "-jar", "devops-integration.jar"]
