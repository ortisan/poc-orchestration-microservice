package com.ortiz.domain.mapper;

import com.ortiz.domain.CorporatePerson;
import com.ortiz.domain.Person;
import com.ortiz.domain.PhysicalPerson;
import com.ortiz.dto.PersonDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = CentralConfig.class, uses = {IPersonTypeEnumMapper.class, IPhoneBusinessMapper.class})
public interface IPersonBusinessMapper {

    @Mapping(source = "cpf_cnpj", target = "cpf")
    @Mapping(target = "insert", ignore = true)
    PhysicalPerson dtoToPhisicalPersonDomain(PersonDTO source);

    @Mapping(source = "cpf_cnpj", target = "cnpj")
    @Mapping(target = "insert", ignore = true)
    CorporatePerson dtoToCorporateDomain(PersonDTO source);

    @InheritInverseConfiguration(name = "dtoToPhisicalPersonDomain")
    PersonDTO domainToDto(PhysicalPerson source);

    @InheritInverseConfiguration(name = "dtoToCorporateDomain")
    PersonDTO domainToDto(CorporatePerson source);

    default PersonDTO mapToDto(Person person) {
        if (person instanceof PhysicalPerson) {
            return this.domainToDto((PhysicalPerson) person);
        }
        return this.domainToDto((CorporatePerson) person);
    }

    default Person mapToDomain(PersonDTO person) {
        if ("P".equals(person.getType())) {
            return this.dtoToPhisicalPersonDomain(person);
        }
        return this.dtoToCorporateDomain(person);
    }
}
