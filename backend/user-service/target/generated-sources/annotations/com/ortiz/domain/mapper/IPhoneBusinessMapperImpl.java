package com.ortiz.domain.mapper;

import com.ortiz.domain.Phone;
import com.ortiz.poc.dto.PhoneDTO;
import com.ortiz.poc.dto.PhoneDTO.PhoneDTOBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IPhoneBusinessMapperImpl implements IPhoneBusinessMapper {

    @Override
    public Phone dtoToDomain(PhoneDTO source) {
        if ( source == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( source.getId() );
        phone.setDdi( source.getDdi() );
        phone.setDdd( source.getDdd() );
        phone.setNumber( source.getNumber() );
        phone.setExtensionLine( source.getExtensionLine() );

        return phone;
    }

    @Override
    public PhoneDTO domainToDto(Phone source) {
        if ( source == null ) {
            return null;
        }

        PhoneDTOBuilder phoneDTO = PhoneDTO.builder();

        phoneDTO.id( source.getId() );
        phoneDTO.ddi( source.getDdi() );
        phoneDTO.ddd( source.getDdd() );
        phoneDTO.number( source.getNumber() );
        phoneDTO.extensionLine( source.getExtensionLine() );

        return phoneDTO.build();
    }
}
