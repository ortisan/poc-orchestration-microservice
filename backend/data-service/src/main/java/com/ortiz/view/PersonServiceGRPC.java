package com.ortiz.view;

import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageV3;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.ortiz.business.IPersonService;
import com.ortiz.business.IPhoneService;
import com.ortiz.dto.PersonDTO;
import com.ortiz.dto.PhoneDTO;
import com.ortiz.grpc.services.*;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static com.ortiz.poc.commons.FieldUtils.getInteger32Value;
import static com.ortiz.poc.commons.FieldUtils.getStringValue;

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
            List<Phone> phones = personDTO.getPhones().stream().map(phoneDTO -> Phone.newBuilder().setId(getStringValue(phoneDTO.getId())).setDdi(getInteger32Value(phoneDTO.getDdi())).setDdd(getInteger32Value(phoneDTO.getDdd())).setNumber(getInteger32Value(phoneDTO.getNumber())).setExtensionLine(getInteger32Value(phoneDTO.getExtensionLine())).build()).collect(Collectors.toList());
            Person response = Person.newBuilder().setTenantId(getStringValue(personDTO.getTenantId())).setPersonId(getStringValue(personDTO.getId())).setCpfCnpj(getStringValue(personDTO.getCpfCnpj())).setName(getStringValue(personDTO.getName())).setType(getStringValue(personDTO.getType())).addAllPhones(phones).build();
            responseObserver.onNext(response);
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
            List<PhoneDTO> phoneDTOS = request.getPhonesList().stream().map(phone -> PhoneDTO.builder().ddi(phone.getDdi().getValue()).ddd(phone.getDdd().getValue()).number(phone.getNumber().getValue()).extensionLine(phone.getExtensionLine().getValue()).build()).collect(Collectors.toList());
            PersonDTO personDTO = PersonDTO.builder().tenantId(request.getTenantId().getValue()).id(request.getPersonId().getValue()).cpfCnpj(request.getCpfCnpj().getValue())
                    .name(request.getName().getValue()).type(request.getType().getValue()).cpfCnpj(request.getCpfCnpj().getValue()).phones(phoneDTOS).build();
            PersonDTO personPersisted = personService.savePerson(personDTO);
            List<Phone> phones = personDTO.getPhones().stream().map(phoneDTO -> Phone.newBuilder().setId(getStringValue(phoneDTO.getId())).setDdi(getInteger32Value(phoneDTO.getDdi())).setDdd(getInteger32Value(phoneDTO.getDdd())).setNumber(getInteger32Value(phoneDTO.getNumber())).setExtensionLine(getInteger32Value(phoneDTO.getExtensionLine())).build()).collect(Collectors.toList());
            Person response = Person.newBuilder().setTenantId(getStringValue(personPersisted.getTenantId())).setPersonId(getStringValue(personPersisted.getId())).setCpfCnpj(getStringValue(personPersisted.getCpfCnpj())).setName(getStringValue(personPersisted.getName())).setType(getStringValue(personPersisted.getType())).addAllPhones(phones).build();
            responseObserver.onNext(response);
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
            List<PhoneDTO> phoneDTOS = request.getPhonesList().stream().map(phone -> PhoneDTO.builder().ddi(phone.getDdi().getValue()).ddd(phone.getDdd().getValue()).number(phone.getNumber().getValue()).extensionLine(phone.getExtensionLine().getValue()).build()).collect(Collectors.toList());
            PersonDTO personDTO = PersonDTO.builder().tenantId(request.getTenantId().getValue()).id(request.getPersonId().getValue()).cpfCnpj(request.getCpfCnpj().getValue())
                    .name(request.getName().getValue()).type(request.getType().getValue()).cpfCnpj(request.getCpfCnpj().getValue()).phones(phoneDTOS).build();
            PersonDTO personPersisted = personService.updatePerson(personDTO);
            List<Phone> phones = personDTO.getPhones().stream().map(phoneDTO -> Phone.newBuilder().setId(getStringValue(phoneDTO.getId())).setDdi(getInteger32Value(phoneDTO.getDdi())).setDdd(getInteger32Value(phoneDTO.getDdd())).setNumber(getInteger32Value(phoneDTO.getNumber())).setExtensionLine(getInteger32Value(phoneDTO.getExtensionLine())).build()).collect(Collectors.toList());
            Person response = Person.newBuilder().setTenantId(getStringValue(personPersisted.getTenantId())).setPersonId(getStringValue(personPersisted.getId())).setCpfCnpj(getStringValue(personPersisted.getCpfCnpj())).setName(getStringValue(personPersisted.getName())).setType(getStringValue(personPersisted.getType())).addAllPhones(phones).build();
            responseObserver.onNext(response);
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
            Phone response = Phone.newBuilder().setId(getStringValue(phoneDTO.getId())).setDdi(getInteger32Value(phoneDTO.getDdi())).setDdd(getInteger32Value(phoneDTO.getDdd())).setNumber(getInteger32Value(phoneDTO.getNumber())).setExtensionLine(getInteger32Value(phoneDTO.getExtensionLine())).build();
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
            PhoneDTO phoneDTO = PhoneDTO.builder().ddi(request.getDdi().getValue()).ddd(request.getDdd().getValue()).number(request.getNumber().getValue()).extensionLine(request.getExtensionLine().getValue()).build();
            PhoneDTO phonePersisted = phoneService.savePhone(phoneDTO);
            Phone response = Phone.newBuilder().setId(getStringValue(phonePersisted.getId())).setDdi(getInteger32Value(phonePersisted.getDdi())).setDdd(getInteger32Value(phonePersisted.getDdd())).setNumber(getInteger32Value(phonePersisted.getNumber())).setExtensionLine(getInteger32Value(phonePersisted.getExtensionLine())).build();
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
            PhoneDTO phoneDTO = PhoneDTO.builder().ddi(request.getDdi().getValue()).ddd(request.getDdd().getValue()).number(request.getNumber().getValue()).extensionLine(request.getExtensionLine().getValue()).build();
            PhoneDTO phonePersisted = phoneService.updatePhone(phoneDTO);
            Phone response = Phone.newBuilder().setId(getStringValue(phonePersisted.getId())).setDdi(getInteger32Value(phonePersisted.getDdi())).setDdd(getInteger32Value(phonePersisted.getDdd())).setNumber(getInteger32Value(phonePersisted.getNumber())).setExtensionLine(getInteger32Value(phonePersisted.getExtensionLine())).build();
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
