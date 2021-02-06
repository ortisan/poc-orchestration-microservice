package com.ortiz.business;

import com.ortiz.poc.dto.PhoneDTO;

public interface IPhoneService {

    PhoneDTO getPhone(String phoneId);

    PhoneDTO savePhone(PhoneDTO phoneDTO);

    PhoneDTO updatePhone(PhoneDTO phoneDTO);
}
