package com.ortiz.view;

import com.google.rpc.Code;
import com.ortiz.business.IPersonService;
import com.ortiz.business.IPhoneService;
import com.ortiz.grpc.services.*;
import com.ortiz.poc.dto.PersonDTO;
import com.ortiz.poc.dto.PhoneDTO;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static com.ortiz.poc.commons.ErrorUtils.handleError;
import static com.ortiz.poc.commons.GRPCMapper.*;

@GrpcService
public class PersonServiceGRPC extends DataServiceGrpc.DataServiceImplBase {

    @Autowired
    private IPersonService personService;

    @Autowired
    private IPhoneService phoneService;

    @Override
    public void getPerson(GetPersonRequest request, StreamObserver<Person> responseObserver) {
        try {
            PersonDTO personDTO = personService.getPerson(request.getTenantId().getValue(), request.getPersonId().getValue());
            Person personResponse = toPersonGRPC(personDTO);
            responseObserver.onNext(personResponse);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }

    @Override
    public void savePerson(Person request, StreamObserver<Person> responseObserver) {
        try {
            PersonDTO personDTO = toPersonDTO(request);

            List<PhoneDTO> phoneDTOS = request.getPhonesList().stream().map(phone -> PhoneDTO.builder().ddi(phone.getDdi().getValue()).ddd(phone.getDdd().getValue()).number(phone.getNumber().getValue()).extensionLine(phone.getExtensionLine().getValue()).build()).collect(Collectors.toList());
            PersonDTO personPersistedDTO = personService.savePerson(personDTO);

            Person personResposnse = toPersonGRPC(personPersistedDTO);
            responseObserver.onNext(personResposnse);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }

    @Override
    public void updatePerson(Person request, StreamObserver<Person> responseObserver) {
        try {
            PersonDTO personDTO = toPersonDTO(request);

            List<PhoneDTO> phoneDTOS = request.getPhonesList().stream().map(phone -> PhoneDTO.builder().ddi(phone.getDdi().getValue()).ddd(phone.getDdd().getValue()).number(phone.getNumber().getValue()).extensionLine(phone.getExtensionLine().getValue()).build()).collect(Collectors.toList());
            PersonDTO personPersistedDTO = personService.updatePerson(personDTO);

            Person personResposnse = toPersonGRPC(personPersistedDTO);
            responseObserver.onNext(personResposnse);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }

    @Override
    public void getPhone(GetPhoneRequest request, StreamObserver<Phone> responseObserver) {
        try {
            PhoneDTO phoneDTO = phoneService.getPhone(request.getPhoneId().getValue());

            Phone response = toPhoneGRPC(phoneDTO);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }

    @Override
    public void savePhone(Phone request, StreamObserver<Phone> responseObserver) {
        try {
            PhoneDTO phoneDTO = toPhoneDTO(request);

            PhoneDTO phonePersisted = phoneService.savePhone(phoneDTO);
            Phone response = toPhoneGRPC(phonePersisted);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }

    @Override
    public void updatePhone(Phone request, StreamObserver<Phone> responseObserver) {
        try {
            PhoneDTO phoneDTO = toPhoneDTO(request);

            PhoneDTO phonePersisted = phoneService.updatePhone(phoneDTO);
            Phone response = toPhoneGRPC(phonePersisted);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (EntityNotFoundException exc) {
            responseObserver.onError(handleError(exc, Code.NOT_FOUND, request));
        } catch (Exception exc) {
            responseObserver.onError(handleError(exc, Code.ABORTED, request));
        }
    }
}
