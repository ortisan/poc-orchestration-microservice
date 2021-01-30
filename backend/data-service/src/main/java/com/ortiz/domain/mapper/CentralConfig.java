package com.ortiz.domain.mapper;

import com.ortiz.domain.Person;
import com.ortiz.dto.PersonDTO;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface CentralConfig {
    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "type", target = "personType")
    @Mapping(source = "id", target = "personIdentity.id")
    @Mapping(target = "insert", ignore = true)
    Person dtoToPersonDomain(PersonDTO source);
}
