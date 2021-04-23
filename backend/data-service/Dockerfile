FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine

RUN apk add --update \
    curl busybox-extras\
    && rm -rf /var/cache/apk/*

WORKDIR '/app'
COPY ./target/data-service.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
