package com.ortiz.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum PersonTypeEnum {
    PHISICAL("P"), CORPORATE("C");

    private final String type;


    PersonTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    private static Map<String, PersonTypeEnum> valuesByPersonType;

    public static PersonTypeEnum getPersonTypeEnumByPersonType(String personType) {
        if (valuesByPersonType == null || valuesByPersonType.isEmpty()) {
            valuesByPersonType = new HashMap<>();
            for (PersonTypeEnum personTypeEnum : PersonTypeEnum.values()) {
                valuesByPersonType.put(personTypeEnum.type, personTypeEnum);
            }
        }
        return valuesByPersonType.get(personType);
    }
}
