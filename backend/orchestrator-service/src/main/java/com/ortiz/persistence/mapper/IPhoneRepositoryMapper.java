package com.ortiz.persistence.mapper;

import com.ortiz.persistence.entities.Phone;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPhoneRepositoryMapper {
    Phone domainToEntity(com.ortiz.domain.Phone phone);
    @InheritInverseConfiguration(name = "domainToEntity")
    com.ortiz.domain.Phone entityToDomain(Phone corporate);
}
