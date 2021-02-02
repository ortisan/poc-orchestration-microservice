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

@GrpcService
public class PersonServiceGRPC extends DataServiceGrpc.DataServiceImplBase {

    @Autowired
    private IPersonService personService;

    @Autowired
    private IPhoneService phoneService;

    @Override
    public void getPerson(GetPersonRequest request, StreamObserver<Person> responseObserver) {
        try {
            PersonDTO person = personService.getPerson(request.getTenantId(), request.getPersonId());
            Person response = Person.newBuilder().setTenantId(person.getTenantId()).setPersonId(person.getId()).setCpfCnpj(person.getCpfCnpj()).setName(person.getName()).setType(person.getType()).build();
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
            List<PhoneDTO> phoneDTOS = request.getPhonesList().stream().map(phone -> PhoneDTO.builder().ddi(phone.getDdi()).ddd(phone.getDdd()).number(phone.getNumber()).extensionLine(phone.getExtensionLine()).build()).collect(Collectors.toList());
            PersonDTO personDTO = PersonDTO.builder().tenantId(request.getTenantId()).id(request.getPersonId()).cpfCnpj(request.getCpfCnpj())
                    .name(request.getName()).type(request.getType()).cpfCnpj(request.getCpfCnpj()).phones(phoneDTOS).build();
            PersonDTO personPersisted = personService.savePerson(personDTO);
            List<Phone> phones = personDTO.getPhones().stream().map(phoneDTO -> Phone.newBuilder().setId(phoneDTO.getId()).setDdi(phoneDTO.getDdi()).setDdd(phoneDTO.getDdd()).setNumber(phoneDTO.getNumber()).setExtensionLine(phoneDTO.getExtensionLine()).build()).collect(Collectors.toList());
            Person response = Person.newBuilder().setTenantId(personPersisted.getTenantId()).setPersonId(personPersisted.getId()).setCpfCnpj(personPersisted.getCpfCnpj()).setName(personPersisted.getName()).setType(personPersisted.getType()).addAllPhones(phones).build();
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
            List<PhoneDTO> phoneDTOS = request.getPhonesList().stream().map(phone -> PhoneDTO.builder().ddi(phone.getDdi()).ddd(phone.getDdd()).number(phone.getNumber()).extensionLine(phone.getExtensionLine()).build()).collect(Collectors.toList());
            PersonDTO personDTO = PersonDTO.builder().tenantId(request.getTenantId()).id(request.getPersonId()).cpfCnpj(request.getCpfCnpj())
                    .name(request.getName()).type(request.getType()).cpfCnpj(request.getCpfCnpj()).phones(phoneDTOS).build();
            PersonDTO personPersisted = personService.updatePerson(personDTO);
            List<Phone> phones = personDTO.getPhones().stream().map(phoneDTO -> Phone.newBuilder().setId(phoneDTO.getId()).setDdi(phoneDTO.getDdi()).setDdd(phoneDTO.getDdd()).setNumber(phoneDTO.getNumber()).setExtensionLine(phoneDTO.getExtensionLine()).build()).collect(Collectors.toList());
            Person response = Person.newBuilder().setTenantId(personPersisted.getTenantId()).setPersonId(personPersisted.getId()).setCpfCnpj(personPersisted.getCpfCnpj()).setName(personPersisted.getName()).setType(personPersisted.getType()).addAllPhones(phones).build();
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
            PhoneDTO phoneDTO = phoneService.getPhone(request.getPhoneId());
            Phone response = Phone.newBuilder().setId(phoneDTO.getId()).setDdi(phoneDTO.getDdi()).setDdd(phoneDTO.getDdd()).setNumber(phoneDTO.getNumber()).setExtensionLine(phoneDTO.getExtensionLine()).build();
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
            PhoneDTO phoneDTO = PhoneDTO.builder().ddi(request.getDdi()).ddd(request.getDdd()).number(request.getNumber()).extensionLine(request.getExtensionLine()).build();
            PhoneDTO phonePersisted = phoneService.savePhone(phoneDTO);
            Phone response = Phone.newBuilder().setId(phonePersisted.getId()).setDdi(phonePersisted.getDdi()).setDdd(phonePersisted.getDdd()).setNumber(phonePersisted.getNumber()).setExtensionLine(phonePersisted.getExtensionLine()).build();
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
            PhoneDTO phoneDTO = PhoneDTO.builder().ddi(request.getDdi()).ddd(request.getDdd()).number(request.getNumber()).extensionLine(request.getExtensionLine()).build();
            PhoneDTO phonePersisted = phoneService.updatePhone(phoneDTO);
            Phone response = Phone.newBuilder().setId(phonePersisted.getId()).setDdi(phonePersisted.getDdi()).setDdd(phonePersisted.getDdd()).setNumber(phonePersisted.getNumber()).setExtensionLine(phonePersisted.getExtensionLine()).build();
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
