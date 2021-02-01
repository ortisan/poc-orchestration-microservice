package com.ortiz.persistence.mapper;


import com.ortiz.domain.VerifiedFieldDomain;
import com.ortiz.persistence.entities.VerifiedFieldEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVerifiedFieldsRepositoryMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fieldName", target = "field.name")
    VerifiedFieldEntity domainToEntity(VerifiedFieldDomain verifiedFieldDomain);

    @InheritInverseConfiguration(name = "domainToEntity")
    VerifiedFieldDomain entityToDomain(VerifiedFieldEntity verifiedFieldEntity);

    List<VerifiedFieldEntity> collectionDomainToEntity(List<VerifiedFieldDomain> verifiedFieldDomains);

    @InheritInverseConfiguration(name = "collectionDomainToEntity")
    List<VerifiedFieldDomain> collectionEntityToDomain(List<VerifiedFieldEntity> verifiedFieldEntities);
}
