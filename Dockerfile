FROM eclipse-temurim:17-jdk-jammy
WORKDIR /up
COPY .mvm/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw 
RUN ./mvnw dependency:resolve 
COPY src ./src 
CMD ["./mvnw", "spring-boot:run"]