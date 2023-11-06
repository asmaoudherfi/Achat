FROM openjdk:8
EXPOSE 8089
WORKDIR /Achat
COPY target/devops-integration.jar /Achat/devops-integration.jar
ENTRYPOINT ["java", "-jar", "devops-integration.jar"]
