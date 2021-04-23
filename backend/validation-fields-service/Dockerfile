FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine

RUN apk add --update \
    curl \
    && rm -rf /var/cache/apk/*

WORKDIR '/app'
COPY ./target/validation-fields-service.jar ./app.jar

EXPOSE 8080
EXPOSE 9090

HEALTHCHECK --interval=10s --timeout=30s CMD curl --fail http://localhost:8080/actuator/health || exit 1

CMD ["java", "-jar", "app.jar"]
