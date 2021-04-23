FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine

RUN apk add --update \
    curl \
    && rm -rf /var/cache/apk/*

WORKDIR '/app'
COPY ./target/orchestrator-service.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
