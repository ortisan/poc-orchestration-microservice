package com.ortiz.com.ortiz.business;

import com.ortiz.dto.DataDTO;
import com.ortiz.dto.PersonDTO;
import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.vfs.ValidationFieldsServiceGrpc;
import io.reactivex.rxjava3.core.Flowable;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class OrchestratorServiceImpl {

    @GrpcClient("data-service")
    private DataServiceGrpc.DataServiceBlockingStub dataServiceStub;

    @GrpcClient("validation-fields-service")
    private ValidationFieldsServiceGrpc.ValidationFieldsServiceBlockingStub validationFieldsServiceStub;

    public DataDTO saveData(DataDTO dataDTO) {

        PersonDTO person = dataDTO.getPerson();
        validationFieldsServiceStub.


    }
}
