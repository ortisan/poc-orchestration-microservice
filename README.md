# POC Microservices Orchestration

POC for testing microservices orchestration patterns.

### Pre-Reqs:

Start the docker containers:

```sh
docker-compose up
```

Force container recreation:

```sh
docker-compose up --build --force-recreate  data-service
```

Stop all containers:

```sh
docker-compose down
docker stop $(docker container  ls -aq)
```

## TODO
