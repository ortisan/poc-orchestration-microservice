package com.ortiz.view;

import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageV3;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.ortiz.business.IPersonService;
import com.ortiz.dto.PersonDTO;
import com.ortiz.grpc.services.DataServiceGrpc;
import com.ortiz.grpc.services.GetPersonRequest;
import com.ortiz.grpc.services.GetPersonResponse;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

@GrpcService
public class PersonServiceGRPC extends DataServiceGrpc.DataServiceImplBase {

    @Autowired
    private IPersonService personService;

    @Override
    public void getPerson(GetPersonRequest request, StreamObserver<GetPersonResponse> responseObserver) {
        try {
            PersonDTO person = personService.getPerson(request.getTenantId(), request.getPersonId());
            GetPersonResponse response = GetPersonResponse.newBuilder().setTenantId(person.getTenantId()).setId(person.getId()).setCpfCnpj(person.getCpfCnpj()).setName(person.getName()).setType(person.getType()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }

    private StatusRuntimeException handleError(Exception exc, Code code, GeneratedMessageV3 request) {
        Status status = Status.newBuilder()
                .setCode(code.getNumber())
                .setMessage(exc.getMessage())
                .addDetails(Any.pack(request))
                .build();
        return StatusProto.toStatusRuntimeException(status);
    }
}
