package com.ortiz.business.rules.validator;

import com.ortiz.business.rules.validator.utils.PredicatesUtils;
import com.ortiz.domain.CorporatePerson;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

@Component
public class CorporatePersonValidator extends PersonValidator<CorporatePerson> {

    @Override
    public void rules() {
        super.rules();
        setPropertyOnContext(this.getClass().getName());
        ruleFor(CorporatePerson::getCnpj)
                .must(not(stringEmptyOrNull()))
                .withMessage("CNPJ is required")
                .must(PredicatesUtils.isCNPJValid)
                .withMessage("CNPJ is invalid")
                .critical();
    }
}

