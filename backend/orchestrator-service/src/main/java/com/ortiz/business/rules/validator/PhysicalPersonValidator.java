package com.ortiz.business.rules.validator;

import com.ortiz.business.rules.validator.utils.PredicatesUtils;
import com.ortiz.domain.PhysicalPerson;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

@Component
public class PhysicalPersonValidator extends PersonValidator<PhysicalPerson> {


    @Override
    public void rules() {
        super.rules();
        setPropertyOnContext(this.getClass().getName());
        ruleFor(PhysicalPerson::getCpf)
                .must(not(stringEmptyOrNull()))
                .withMessage("CPF is required")
                .must(PredicatesUtils.isCPFValid)
                .withMessage("CPF is invalid")
                .critical();

    }


}

