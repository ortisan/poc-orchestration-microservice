package com.ortiz.persistence.mapper;

import com.ortiz.persistence.entities.Person;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.WARN, mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG
)
public interface CentralConfig {
    @Mapping(source = "fullName", target = "name")
    @Mapping(source = "personType", target = "type")
    @Mapping(source = "tenantId", target = "personId.tenantId")
    @Mapping(source = "personIdentity.id", target = "personId.personId")
    Person domainToEntity(com.ortiz.domain.Person person);
}
