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
    curl busybox-extras\
    && rm -rf /var/cache/apk/*

WORKDIR '/app'
COPY ./target/demo-application.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
