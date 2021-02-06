package com.ortiz.domain.mapper;

import com.ortiz.domain.VerifiedFieldDomain;
import com.ortiz.dto.ValidationFieldDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVerifiedFieldBusinessMapper {

    VerifiedFieldDomain toDomain(ValidationFieldDTO source);

    @InheritInverseConfiguration(name = "toDomain")
    ValidationFieldDTO toDto(VerifiedFieldDomain source);

    List<VerifiedFieldDomain> toDomainList(List<ValidationFieldDTO> source);

    @InheritInverseConfiguration(name = "toDomainList")
    List<ValidationFieldDTO> toDtoList(List<VerifiedFieldDomain> source);
}
