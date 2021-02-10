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
cd backend/data-service
mvn clean compile package
cd - 

cd backend/validation-fields-service
mvn clean compile package
cd - 

cd backend/orchestrator-service
mvn clean compile package
cd - 

# Start docker containers. Obs: the services will build Dockerfile
docker-compose up --build -d
cd - 

trap : 0

echo >&2 '
************
*** DONE *** 
************
'