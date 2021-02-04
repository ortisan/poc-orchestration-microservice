package com.ortiz.com.ortiz.business;

import com.ortiz.dto.DataDTO;
import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.vfs.ValidationFieldsServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class OrchestratorServiceImpl {

    @GrpcClient("data-service")
    private DataServiceGrpc.DataServiceBlockingStub dataServiceStub;

    @GrpcClient("validation-fields-service")
    private ValidationFieldsServiceGrpc.ValidationFieldsServiceBlockingStub validationFieldsServiceStub;

    public DataDTO saveData(DataDTO dataDTO) {

        return null;

    }
}
