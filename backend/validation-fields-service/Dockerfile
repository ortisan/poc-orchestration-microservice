# FROM maven:3.6.3-jdk-11 as target
# WORKDIR '/app'
# COPY pom.xml .
# RUN mvn dependency:go-offline
# COPY src/ /app/src/
# RUN mvn package

# # Step : Package image
# FROM openjdk:11-jre-alpine
# WORKDIR '/app'
# COPY --from=target /app/target/validation-fields-service.jar /app/validation-fields-service.jar
# # CMD ["./mvnw", "spring-boot:run", "-Dspring.profiles.active=compose"]
# CMD ["java", "-jar", "validation-fields-service.jar", "-Dspring.profiles.active=compose"]


# Step : Package image
FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine

RUN apk add --update \
    curl \
    && rm -rf /var/cache/apk/*

WORKDIR '/app'
COPY ./target/validation-fields-service.jar ./validation-fields-service.jar

EXPOSE 8080 9090

# CMD ["./mvnw", "spring-boot:run", "-Dspring.profiles.active=compose"]
CMD ["java", "-Dspring.profiles.active=compose", "-jar", "validation-fields-service.jar"]
