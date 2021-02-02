package com.ortiz.persistence.mapper;


import com.ortiz.domain.CorporatePerson;
import com.ortiz.domain.mapper.IPersonTypeEnumMapper;
import com.ortiz.persistence.entities.Corporate;
import com.ortiz.persistence.entities.Person;
import com.ortiz.persistence.entities.PhysicalPerson;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = CentralConfig.class, uses = {IPersonTypeEnumMapper.class})
public interface IPersonRepositoryMapper {

    @Mapping(source = "cpf", target = "cpf")
    PhysicalPerson phisicalPersonDomainToEntity(com.ortiz.domain.PhysicalPerson physicalPerson);

    @Mapping(source = "cnpj", target = "cnpj")
    Corporate corporateDomainToEntity(CorporatePerson corporate);

    @InheritInverseConfiguration(name = "phisicalPersonDomainToEntity")
    com.ortiz.domain.PhysicalPerson entityToDomain(PhysicalPerson corporate);

    @InheritInverseConfiguration(name = "corporateDomainToEntity")
    CorporatePerson entityToDomain(Corporate corporate);

    default com.ortiz.domain.Person mapToDomain(Person person) {
        if (person instanceof PhysicalPerson) {
            return this.entityToDomain((PhysicalPerson) person);
        }
        return this.entityToDomain((Corporate) person);
    }

    default Person mapToEntity(com.ortiz.domain.Person person) {
        if (person instanceof com.ortiz.domain.PhysicalPerson) {
            return this.phisicalPersonDomainToEntity((com.ortiz.domain.PhysicalPerson) person);
        }
        return this.corporateDomainToEntity((CorporatePerson) person);
    }
}
