package com.ortiz.persistence.mapper;

import com.ortiz.domain.Phone;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IPhoneRepositoryMapperImpl implements IPhoneRepositoryMapper {

    @Override
    public com.ortiz.persistence.entities.Phone domainToEntity(Phone phone) {
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

    @Override
    public Phone entityToDomain(com.ortiz.persistence.entities.Phone corporate) {
        if ( corporate == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( corporate.getId() );
        phone.setDdi( corporate.getDdi() );
        phone.setDdd( corporate.getDdd() );
        phone.setNumber( corporate.getNumber() );
        phone.setExtensionLine( corporate.getExtensionLine() );

        return phone;
    }
}
