package com.ortiz;

import com.ortiz.view.PersonServiceGRPC;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class TestServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(9090)
                .addService(new PersonServiceGRPC()).build();

        server.start();
        server.awaitTermination();
    }
}
