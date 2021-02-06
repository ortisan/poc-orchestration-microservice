package com.ortiz.domain.mapper;

import com.ortiz.domain.Phone;
import com.ortiz.poc.dto.PhoneDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPhoneBusinessMapper {

    @Mapping(target = "insert", ignore = true)
    Phone dtoToDomain(PhoneDTO source);
    @InheritInverseConfiguration(name = "dtoToDomain")
    PhoneDTO domainToDto(Phone source);
}
