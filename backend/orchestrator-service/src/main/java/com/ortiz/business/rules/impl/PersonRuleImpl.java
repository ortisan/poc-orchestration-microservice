package com.ortiz.business.rules.impl;


import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import com.ortiz.business.rules.IPersonRule;
import com.ortiz.business.rules.IPhoneRule;
import com.ortiz.business.rules.validator.CorporatePersonValidator;
import com.ortiz.business.rules.validator.PhysicalPersonValidator;
import com.ortiz.business.rules.validator.utils.ValidatorUtils;
import com.ortiz.domain.CorporatePerson;
import com.ortiz.domain.Person;
import com.ortiz.domain.Phone;
import com.ortiz.domain.PhysicalPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonRuleImpl implements IPersonRule {

    @Autowired
    private IPhoneRule phoneRule;
    @Autowired
    private PhysicalPersonValidator physicalPersonValidator;
    @Autowired
    private CorporatePersonValidator corporatePersonValidator;

    @Override
    public ValidationResult validate(Person person, boolean isInsert) {
        ValidationResult result;
        person.setInsert(isInsert);
        if (person instanceof PhysicalPerson) {
            result = physicalPersonValidator.validate((PhysicalPerson) person);
        } else {
            result = corporatePersonValidator.validate((CorporatePerson) person);
        }
        final List<Phone> phones = person.getPhones();
        if (!CollectionUtils.isEmpty(phones)) {
            phones.forEach(phone -> {
                phone.setInsert(isInsert);
            });
            ValidationResult phonesValidationResult = phoneRule.validate(phones);
            result = ValidatorUtils.combine(result, phonesValidationResult);
        }
        if (!result.isValid()) {
            Collection<Error> errors = result.getErrors();
            String errorsStr = errors.stream().map(Error::toString).collect(Collectors.joining(", "));
            throw new IllegalArgumentException(errorsStr);
        }
        return null;
    }
}
