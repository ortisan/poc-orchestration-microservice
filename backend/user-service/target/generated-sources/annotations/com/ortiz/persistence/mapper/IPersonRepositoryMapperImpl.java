package com.ortiz.persistence.mapper;

import com.ortiz.domain.CorporatePerson;
import com.ortiz.domain.PersonIdentity;
import com.ortiz.domain.Phone;
import com.ortiz.domain.mapper.IPersonTypeEnumMapper;
import com.ortiz.persistence.entities.Corporate;
import com.ortiz.persistence.entities.PersonId;
import com.ortiz.persistence.entities.PhysicalPerson;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IPersonRepositoryMapperImpl implements IPersonRepositoryMapper {

    @Autowired
    private IPersonTypeEnumMapper iPersonTypeEnumMapper;

    @Override
    public PhysicalPerson phisicalPersonDomainToEntity(com.ortiz.domain.PhysicalPerson physicalPerson) {
        if ( physicalPerson == null ) {
            return null;
        }

        PhysicalPerson physicalPerson1 = new PhysicalPerson();

        if ( physicalPerson.getPersonIdentity() != null ) {
            if ( physicalPerson1.getPersonId() == null ) {
                physicalPerson1.setPersonId( new PersonId() );
            }
            personIdentityToPersonId( physicalPerson.getPersonIdentity(), physicalPerson1.getPersonId() );
        }
        if ( physicalPerson1.getPersonId() == null ) {
            physicalPerson1.setPersonId( new PersonId() );
        }
        physicalPersonToPersonId( physicalPerson, physicalPerson1.getPersonId() );
        physicalPerson1.setCpf( physicalPerson.getCpf() );
        physicalPerson1.setName( physicalPerson.getFullName() );
        physicalPerson1.setType( iPersonTypeEnumMapper.enumToString( physicalPerson.getPersonType() ) );
        physicalPerson1.setPhones( phoneListToPhoneList( physicalPerson.getPhones() ) );

        return physicalPerson1;
    }

    @Override
    public Corporate corporateDomainToEntity(CorporatePerson corporate) {
        if ( corporate == null ) {
            return null;
        }

        Corporate corporate1 = new Corporate();

        if ( corporate.getPersonIdentity() != null ) {
            if ( corporate1.getPersonId() == null ) {
                corporate1.setPersonId( new PersonId() );
            }
            personIdentityToPersonId( corporate.getPersonIdentity(), corporate1.getPersonId() );
        }
        if ( corporate1.getPersonId() == null ) {
            corporate1.setPersonId( new PersonId() );
        }
        corporatePersonToPersonId( corporate, corporate1.getPersonId() );
        corporate1.setCnpj( corporate.getCnpj() );
        corporate1.setName( corporate.getFullName() );
        corporate1.setType( iPersonTypeEnumMapper.enumToString( corporate.getPersonType() ) );
        corporate1.setPhones( phoneListToPhoneList( corporate.getPhones() ) );

        return corporate1;
    }

    @Override
    public com.ortiz.domain.PhysicalPerson entityToDomain(PhysicalPerson corporate) {
        if ( corporate == null ) {
            return null;
        }

        com.ortiz.domain.PhysicalPerson physicalPerson = new com.ortiz.domain.PhysicalPerson();

        physicalPerson.setPersonIdentity( personIdToPersonIdentity( corporate.getPersonId() ) );
        physicalPerson.setCpf( corporate.getCpf() );
        physicalPerson.setFullName( corporate.getName() );
        physicalPerson.setPersonType( iPersonTypeEnumMapper.mapPersonType( corporate.getType() ) );
        physicalPerson.setTenantId( corporatePersonIdTenantId( corporate ) );
        physicalPerson.setPhones( phoneListToPhoneList1( corporate.getPhones() ) );

        return physicalPerson;
    }

    @Override
    public CorporatePerson entityToDomain(Corporate corporate) {
        if ( corporate == null ) {
            return null;
        }

        CorporatePerson corporatePerson = new CorporatePerson();

        corporatePerson.setPersonIdentity( personIdToPersonIdentity( corporate.getPersonId() ) );
        corporatePerson.setCnpj( corporate.getCnpj() );
        corporatePerson.setFullName( corporate.getName() );
        corporatePerson.setPersonType( iPersonTypeEnumMapper.mapPersonType( corporate.getType() ) );
        corporatePerson.setTenantId( corporatePersonIdTenantId1( corporate ) );
        corporatePerson.setPhones( phoneListToPhoneList1( corporate.getPhones() ) );

        return corporatePerson;
    }

    protected void personIdentityToPersonId(PersonIdentity personIdentity, PersonId mappingTarget) {
        if ( personIdentity == null ) {
            return;
        }

        mappingTarget.setPersonId( personIdentity.getId() );
    }

    protected void physicalPersonToPersonId(com.ortiz.domain.PhysicalPerson physicalPerson, PersonId mappingTarget) {
        if ( physicalPerson == null ) {
            return;
        }

        mappingTarget.setTenantId( physicalPerson.getTenantId() );
    }

    protected com.ortiz.persistence.entities.Phone phoneToPhone(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        com.ortiz.persistence.entities.Phone phone1 = new com.ortiz.persistence.entities.Phone();

        phone1.setId( phone.getId() );
        phone1.setDdi( phone.getDdi() );
        phone1.setDdd( phone.getDdd() );
        phone1.setNumber( phone.getNumber() );
        phone1.setExtensionLine( phone.getExtensionLine() );

        return phone1;
    }

    protected List<com.ortiz.persistence.entities.Phone> phoneListToPhoneList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<com.ortiz.persistence.entities.Phone> list1 = new ArrayList<com.ortiz.persistence.entities.Phone>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhone( phone ) );
        }

        return list1;
    }

    protected void corporatePersonToPersonId(CorporatePerson corporatePerson, PersonId mappingTarget) {
        if ( corporatePerson == null ) {
            return;
        }

        mappingTarget.setTenantId( corporatePerson.getTenantId() );
    }

    protected PersonIdentity personIdToPersonIdentity(PersonId personId) {
        if ( personId == null ) {
            return null;
        }

        PersonIdentity personIdentity = new PersonIdentity();

        personIdentity.setId( personId.getPersonId() );

        return personIdentity;
    }

    private String corporatePersonIdTenantId(PhysicalPerson physicalPerson) {
        if ( physicalPerson == null ) {
            return null;
        }
        PersonId personId = physicalPerson.getPersonId();
        if ( personId == null ) {
            return null;
        }
        String tenantId = personId.getTenantId();
        if ( tenantId == null ) {
            return null;
        }
        return tenantId;
    }

    protected Phone phoneToPhone1(com.ortiz.persistence.entities.Phone phone) {
        if ( phone == null ) {
            return null;
        }

        Phone phone1 = new Phone();

        phone1.setId( phone.getId() );
        phone1.setDdi( phone.getDdi() );
        phone1.setDdd( phone.getDdd() );
        phone1.setNumber( phone.getNumber() );
        phone1.setExtensionLine( phone.getExtensionLine() );

        return phone1;
    }

    protected List<Phone> phoneListToPhoneList1(List<com.ortiz.persistence.entities.Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( com.ortiz.persistence.entities.Phone phone : list ) {
            list1.add( phoneToPhone1( phone ) );
        }

        return list1;
    }

    private String corporatePersonIdTenantId1(Corporate corporate) {
        if ( corporate == null ) {
            return null;
        }
        PersonId personId = corporate.getPersonId();
        if ( personId == null ) {
            return null;
        }
        String tenantId = personId.getTenantId();
        if ( tenantId == null ) {
            return null;
        }
        return tenantId;
    }
}
