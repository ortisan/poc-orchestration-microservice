package com.ortiz.domain.mapper;

import com.ortiz.domain.VerifiedFieldDomain;
import com.ortiz.dto.VerifiedFieldDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVerifiedFieldBusinessMapper {

    VerifiedFieldDomain toDomain(VerifiedFieldDTO source);

    @InheritInverseConfiguration(name = "toDomain")
    VerifiedFieldDTO toDto(VerifiedFieldDomain source);

    List<VerifiedFieldDomain> toDomainList(List<VerifiedFieldDTO> source);

    @InheritInverseConfiguration(name = "toDomainList")
    List<VerifiedFieldDTO> toDtoList(List<VerifiedFieldDomain> source);
}
