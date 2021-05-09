package com.ortiz.dto;

import com.ortiz.com.ortiz.business.StateEnum;
import com.ortiz.dto.DataDTO;
import com.ortiz.poc.dto.PersonDTO;
import com.ortiz.poc.dto.ValidationFieldDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ContextFlowDTO {

    private StateEnum stateEnum;

    private DataDTO data;

    private List<ValidationFieldDTO> validatedFields;

    private PersonDTO personValidateFieldsFiltered;

    private PersonDTO personValidated;

    private PersonDTO personPersisted;

    private List<ValidationFieldDTO> validationFieldsPersisted;

}
