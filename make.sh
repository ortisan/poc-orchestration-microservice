#!/bin/sh

#https://stackoverflow.com/questions/2870992/automatic-exit-from-bash-shell-script-on-error
abort()
{
    echo >&2 '
***************
*** ABORTED ***
***************
'
    echo "An error occurred. Exiting..." >&2
    exit 1
}

trap 'abort' 0

set -e

## Building stubs
cd backend/data-service-stub
mvn clean compile install
cd - 

cd backend/validation-fields-service-stub
mvn clean compile install 
cd - 

## Building poc commons
cd backend/poc-commons
mvn clean compile install 
cd - 

## Building services
cd backend/demo
mvn clean compile package
docker build -t tentativafc/demo:latest -f Dockerfile .
docker push tentativafc/demo:latest
cd - 

## Building services
cd backend/data-service
mvn clean compile package
docker build -t tentativafc/poc-data-service:1.0.1-snapshot -f Dockerfile .
docker push tentativafc/poc-data-service:1.0.1-snapshot
cd - 

cd backend/validation-fields-service
mvn clean compile package
docker build -t tentativafc/poc-validation-fields-service:1.0.0-snapshot -f Dockerfile .
docker push tentativafc/poc-validation-fields-service:1.0.0-snapshot
cd - 

cd backend/orchestrator-service
mvn clean compile package
docker build -t tentativafc/poc-orchestrator-service:1.0.0-snapshot -f Dockerfile .
docker push tentativafc/poc-orchestrator-service:1.0.0-snapshot
cd - 

# Start docker containers. Obs: the services will build Dockerfile

trap : 0

echo >&2 '
************
*** DONE *** 
************
'