package com.ortiz.com.ortiz.business;

import com.ortiz.dto.PersonDTO;
import com.ortiz.dto.VerifiedFieldDTO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DataFilteringService {

    @Value("#{${fields_dto_mapper}}")
    private Map<String, String> mapDtoFields;

    public PersonDTO filterData(PersonDTO personDTO, List<VerifiedFieldDTO> fields) {
        fields.stream().filter(verifiedFieldDTO -> !verifiedFieldDTO.getServerValidated()).forEach(verifiedFieldDTO -> {
            String dtoFieldName = mapDtoFields.get(verifiedFieldDTO.getFieldName());
            try {
                BeanUtils.setProperty(personDTO, dtoFieldName, null);
            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }
        });
        return personDTO;
    }
}
