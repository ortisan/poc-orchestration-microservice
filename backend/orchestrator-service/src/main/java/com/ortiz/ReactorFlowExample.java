package com.ortiz;

import com.ortiz.dto.ContextFieldDTO;
import com.ortiz.dto.ContextFlowDTO;
import com.ortiz.dto.DataDTO;
import com.ortiz.poc.dto.PersonDTO;
import com.ortiz.poc.dto.PhoneDTO;
import com.ortiz.poc.dto.ValidationFieldDTO;
import com.ortiz.poc.fields.FieldProcessor;
import com.ortiz.poc.fields.FieldTypeEnum;
import org.apache.commons.beanutils.PropertyUtils;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ReactorFlowExample {

    public static void main(String[] args) {

        PhoneDTO phoneDTO = PhoneDTO.builder().ddi(55).ddd(11).number(975732253).build();
        PersonDTO personDTO = PersonDTO.builder().name("Marcelo").cpfCnpj("50639325092").type("F").phones(Arrays.asList(phoneDTO)).build();
        DataDTO dataDTO = DataDTO.builder().person(personDTO).build();
        ContextFlowDTO context = ContextFlowDTO.builder().data(dataDTO).build();
        AtomicReference<ContextFlowDTO> contextFlowAtomicReference = new AtomicReference<>(context);

        // Transform 1 to N. We transform into from COLD to HOT using cache()
        Flux<ContextFieldDTO> publishFieldsFlux = Mono.just(contextFlowAtomicReference).
                flatMapMany((AtomicReference<ContextFlowDTO> atomicContext) -> {
                    System.out.println("Mapping Dto to fields....");
//                    List<ContextFieldDTO> fields = new ArrayList<>();
//                    fields.add(ContextFieldDTO.builder().context(atomicContext.get()).name("CPF_CNPJ").value(atomicContext.get().getData().getPerson().getCpfCnpj()).type(TypeEnum.SINGLE).build());
//                    fields.add(ContextFieldDTO.builder().context(atomicContext.get()).name("PERSON_TYPE").value(atomicContext.get().getData().getPerson().getType()).type(TypeEnum.SINGLE).build());
//                    fields.add(ContextFieldDTO.builder().context(atomicContext.get()).name("PERSON_NAME").value(atomicContext.get().getData().getPerson().getName()).type(TypeEnum.SINGLE).build());
//                    List<ContextFieldDTO> phones = atomicContext.get().getData().getPerson().getPhones().stream().map(phone -> ContextFieldDTO.builder().context(atomicContext.get()).name("PHONE").value(phone).type(TypeEnum.MULTIPLE_PHONE).build()).collect(Collectors.toList());
//                    fields.addAll(phones);
//                    return ConnectableFlux.fromIterable(fields).cache();

                    List<ContextFieldDTO> fields = dtoToFields(atomicContext.get().getData().getPerson());
                    System.out.println("fields = " + fields);
                    return ConnectableFlux.fromIterable(fields);
                }).cache();

        // Filter by single fields
        Flux<ContextFieldDTO> singleFieldsFlux = publishFieldsFlux.filter(stateFieldDto -> stateFieldDto.getType() == FieldTypeEnum.SINGLE);
        // Filter by phone fields
        Flux<ContextFieldDTO> phoneFieldsFlux = publishFieldsFlux.filter(stateFieldDto -> stateFieldDto.getType() == FieldTypeEnum.MULTIPLE_PHONE);
        // Combined Flux
        Flux<ContextFieldDTO> combinedSingleAndMultipleFlux = Flux.concat(singleFieldsFlux, phoneFieldsFlux);
        // Validation Simulation flux
        Flux<ValidationFieldDTO> validationFieldDTOFlux = combinedSingleAndMultipleFlux.map(stateFieldDtos -> {
            return ValidationFieldDTO.builder().fieldName(stateFieldDtos.getName()).value(stateFieldDtos.getValue().toString()).level(200).build();
        });
        // Subscription
        validationFieldDTOFlux.subscribe(System.out::println);
    }

    public static List<ContextFieldDTO> dtoToFields(PersonDTO personDTO) {
        System.out.println("personDTO = " + personDTO);
        return Arrays.stream(personDTO.getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(FieldProcessor.class)).flatMap(field -> {
            FieldProcessor annotation = field.getAnnotation(FieldProcessor.class);
            if (annotation.fieldType() == FieldTypeEnum.SINGLE) {
                try {
                    Object value = PropertyUtils.getProperty(personDTO, field.getName());
                    return Arrays.asList(ContextFieldDTO.builder().name(annotation.fieldName()).type(annotation.fieldType()).critical(annotation.isCritical()).value(value).build()).stream();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (annotation.fieldType() == FieldTypeEnum.MULTIPLE_PHONE) {
                try {
                    List<PhoneDTO> phonesDTO = (List<PhoneDTO>) PropertyUtils.getProperty(personDTO, field.getName());
                    return phonesDTO.stream().map(phoneDTO -> ContextFieldDTO.builder().name(annotation.fieldName()).type(annotation.fieldType()).critical(annotation.isCritical()).value(phoneDTO).build());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            // TODO Others
            return null;
        }).collect(Collectors.toList());
    }
}
