package com.ortiz;

import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.GetPersonRequest;
import com.ortiz.grpc.services.Person;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static com.ortiz.poc.commons.FieldUtils.getStringValue;


public class TestClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        DataServiceGrpc.DataServiceBlockingStub stub
                = DataServiceGrpc.newBlockingStub(channel);

        Person personResponse = stub.getPerson(GetPersonRequest.newBuilder()
                .setTenantId(getStringValue("1234"))
                .setPersonId(getStringValue("5a783ece-0ef5-48f2-a803-df7b5d9adf2e"))
                .build());


        System.out.println("personResponse = " + personResponse);
        System.out.println("phones = " + personResponse.getPhonesList());
        System.out.println("extensionLine = " + personResponse.getPhonesList().stream().findFirst().get().getExtensionLine().getValue());
        channel.shutdown();
    }
}
