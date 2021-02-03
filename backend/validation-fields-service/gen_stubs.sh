#!/bin/bash
DEST_DIR_STUBS_DATA_SERVICE=./stubs/data-service-stub
DEST_DIR_STUBS_VALIDATION_FIELDS_SERVICE=./stubs/validation-fields-service-stub

mkdir -p $DEST_DIR_STUBS_DATA_SERVICE
mkdir -p $DEST_DIR_STUBS_VALIDATION_FIELDS_SERVICE

protoc --plugin=protoc-gen-grpc-java --grpc-java_out=$DEST_DIR_STUBS_DATA_SERVICE src/main/resources/data-service.proto
protoc --plugin=protoc-gen-grpc-java --grpc-java_out=$DEST_DIR_STUBS_VALIDATION_FIELDS_SERVICE src/main/resources/validation-fields-service.proto
