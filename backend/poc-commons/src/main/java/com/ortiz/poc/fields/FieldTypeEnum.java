package com.ortiz.poc.fields;

public enum FieldTypeEnum {

    SINGLE(true), MULTIPLE_ADDRESS(false), MULTIPLE_PHONE(false);

    private final boolean isSingleField;

    FieldTypeEnum(boolean isSingleField) {
        this.isSingleField = isSingleField;
    }

    public boolean isSingleField() {
        return isSingleField;
    }
}
