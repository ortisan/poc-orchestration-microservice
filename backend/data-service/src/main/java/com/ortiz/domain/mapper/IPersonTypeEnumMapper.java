package com.ortiz.domain.mapper;

import com.ortiz.domain.enums.PersonTypeEnum;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPersonTypeEnumMapper {

    default String enumToString(PersonTypeEnum personTypeEnum) {
        return personTypeEnum.getType();
    }

    default PersonTypeEnum mapPersonType(String personType) {
        return PersonTypeEnum.getPersonTypeEnumByPersonType(personType);
    }
}
