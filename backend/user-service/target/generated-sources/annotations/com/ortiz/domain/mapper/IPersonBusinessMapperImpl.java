package com.ortiz.domain.mapper;

import com.ortiz.domain.CorporatePerson;
import com.ortiz.domain.PersonIdentity;
import com.ortiz.domain.Phone;
import com.ortiz.domain.PhysicalPerson;
import com.ortiz.poc.dto.PersonDTO;
import com.ortiz.poc.dto.PersonDTO.PersonDTOBuilder;
import com.ortiz.poc.dto.PhoneDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IPersonBusinessMapperImpl implements IPersonBusinessMapper {

    @Autowired
    private IPersonTypeEnumMapper iPersonTypeEnumMapper;
    @Autowired
    private IPhoneBusinessMapper iPhoneBusinessMapper;

    @Override
    public PhysicalPerson dtoToPhisicalPersonDomain(PersonDTO source) {
        if ( source == null ) {
            return null;
        }

        PhysicalPerson physicalPerson = new PhysicalPerson();

        physicalPerson.setPersonIdentity( personDTOToPersonIdentity( source ) );
        physicalPerson.setCpf( source.getCpfCnpj() );
        physicalPerson.setFullName( source.getName() );
        physicalPerson.setPersonType( iPersonTypeEnumMapper.mapPersonType( source.getType() ) );
        physicalPerson.setTenantId( source.getTenantId() );
        physicalPerson.setPhones( phoneDTOListToPhoneList( source.getPhones() ) );

        return physicalPerson;
    }

    @Override
    public CorporatePerson dtoToCorporateDomain(PersonDTO source) {
        if ( source == null ) {
            return null;
        }

        CorporatePerson corporatePerson = new CorporatePerson();

        corporatePerson.setPersonIdentity( personDTOToPersonIdentity1( source ) );
        corporatePerson.setCnpj( source.getCpfCnpj() );
        corporatePerson.setFullName( source.getName() );
        corporatePerson.setPersonType( iPersonTypeEnumMapper.mapPersonType( source.getType() ) );
        corporatePerson.setTenantId( source.getTenantId() );
        corporatePerson.setPhones( phoneDTOListToPhoneList( source.getPhones() ) );

        return corporatePerson;
    }

    @Override
    public PersonDTO domainToDto(PhysicalPerson source) {
        if ( source == null ) {
            return null;
        }

        PersonDTOBuilder personDTO = PersonDTO.builder();

        personDTO.cpfCnpj( source.getCpf() );
        personDTO.name( source.getFullName() );
        personDTO.type( iPersonTypeEnumMapper.enumToString( source.getPersonType() ) );
        personDTO.id( sourcePersonIdentityId( source ) );
        personDTO.tenantId( source.getTenantId() );
        personDTO.phones( phoneListToPhoneDTOList( source.getPhones() ) );

        return personDTO.build();
    }

    @Override
    public PersonDTO domainToDto(CorporatePerson source) {
        if ( source == null ) {
            return null;
        }

        PersonDTOBuilder personDTO = PersonDTO.builder();

        personDTO.cpfCnpj( source.getCnpj() );
        personDTO.name( source.getFullName() );
        personDTO.type( iPersonTypeEnumMapper.enumToString( source.getPersonType() ) );
        personDTO.id( sourcePersonIdentityId1( source ) );
        personDTO.tenantId( source.getTenantId() );
        personDTO.phones( phoneListToPhoneDTOList( source.getPhones() ) );

        return personDTO.build();
    }

    protected PersonIdentity personDTOToPersonIdentity(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonIdentity personIdentity = new PersonIdentity();

        personIdentity.setId( personDTO.getId() );

        return personIdentity;
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( iPhoneBusinessMapper.dtoToDomain( phoneDTO ) );
        }

        return list1;
    }

    protected PersonIdentity personDTOToPersonIdentity1(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonIdentity personIdentity = new PersonIdentity();

        personIdentity.setId( personDTO.getId() );

        return personIdentity;
    }

    private String sourcePersonIdentityId(PhysicalPerson physicalPerson) {
        if ( physicalPerson == null ) {
            return null;
        }
        PersonIdentity personIdentity = physicalPerson.getPersonIdentity();
        if ( personIdentity == null ) {
            return null;
        }
        String id = personIdentity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( iPhoneBusinessMapper.domainToDto( phone ) );
        }

        return list1;
    }

    private String sourcePersonIdentityId1(CorporatePerson corporatePerson) {
        if ( corporatePerson == null ) {
            return null;
        }
        PersonIdentity personIdentity = corporatePerson.getPersonIdentity();
        if ( personIdentity == null ) {
            return null;
        }
        String id = personIdentity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
