package com.ortiz;

import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.GetPersonRequest;
import com.ortiz.grpc.services.GetPersonResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TestClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090)
                .usePlaintext()
                .build();

        DataServiceGrpc.DataServiceBlockingStub stub
                = DataServiceGrpc.newBlockingStub(channel);

        GetPersonResponse personResponse = stub.getPerson(GetPersonRequest.newBuilder()
                .setTenantId("123456")
                .setPersonId("123456")
                .build());

        System.out.println("personResponse = " + personResponse);

        channel.shutdown();
    }
}
