# POC Microservices Orchestration

POC for testing microservices orchestration patterns.

### Run:

Checkout this project and install into local repository (with this bug [#495](https://github.com/yidongnan/grpc-spring-boot-starter/issues/495) fixed):

```sh
git clone git@github.com:tentativafc/grpc-spring-boot-starter.git
cd grpc-spring-boot-starter
./gradlew publishToMavenLocal
```

Make projects and run docker compose (Build, Uploads images and start docker compose)

```sh
./make.sh
```

Start application

```sh
docker-compose up -d
```

Generate data for performance tests (Jmeter script Test Plan.jmx)

1. Create virtualenv and install python dependencies

2. Make projects and run docker compose (Build, Uploads images and start docker compose) this step does not need repeat.

   ```sh
   cd backend/gen-data
   virtualenv env
   source env/bin/activate
   pip install -r requirements.txt
   ```

3. Generate data:

   ```sh
   ./gen_data.sh
   ```

### Useful commands:

Force container recreation:

```sh
docker-compose up --build --force-recreate  data-service
```

Stop all containers:

```sh
docker-compose down
docker stop $(docker container  ls -aq)
```

Run Spring Boot like nodemon (nodejs)

```sh
./mvnw spring-boot:run
```

### Services and port numbers:

| Service                         | Port Number | Type/Tech       |
| ------------------------------- | ----------- | --------------- |
| Mysql Data-Service              | 3306        | DB              |
| Mysql Validation-Fields-Service | 3307        | DB              |
| DLQ                             | 5672        | Rabbit MQ       |
| Data-Service                    | 8080        | Spring Boot App |
| Validation-Fields-Service       | 8081        | Spring Boot App |
| Data-Service-RPC                | 9090        | GRPC            |
| Validation-Fields-Service-RPC   | 9091        | GRPC            |
| Orchestrator-Service            | 8082        | Spring Boot App |
| Service-Discovery               | 8500        | Consul          |
| Frontend                        | 8083        | VUEjs           |
