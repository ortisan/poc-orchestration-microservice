package com.ortiz.persistence.repositories.service;

import com.ortiz.domain.Phone;

public interface IPhoneRepository {
    Phone getPhone(String phoneId);

    Phone savePhone(Phone phone);

    Phone updatePhone(Phone phone);
}
