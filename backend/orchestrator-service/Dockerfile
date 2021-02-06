# FROM maven:3.6.3-jdk-11 as target
# WORKDIR '/app'
# COPY pom.xml .
# RUN mvn dependency:go-offline
# COPY src/ /app/src/
# RUN mvn package

# # Step : Package image
# FROM openjdk:11-jre-alpine
# WORKDIR '/app'
# COPY --from=target /app/target/orchestrator-service.jar /app/orchestrator-service.jar
# # CMD ["./mvnw", "spring-boot:run", "-Dspring.profiles.active=compose"]
# CMD ["java", "-jar", "orchestrator-service.jar", "-Dspring.profiles.active=compose"]


# Step : Package image
FROM openjdk:11-jre-slim
WORKDIR '/app'
COPY ./target/orchestrator-service.jar ./orchestrator-service.jar
# CMD ["./mvnw", "spring-boot:run", "-Dspring.profiles.active=compose"]
CMD ["java", "-jar", "orchestrator-service.jar", "-Dspring.profiles.active=compose"]
