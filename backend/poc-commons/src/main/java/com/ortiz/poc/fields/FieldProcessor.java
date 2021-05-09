package com.ortiz.poc.fields;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldProcessor {
    public String fieldName();
    public FieldTypeEnum fieldType();
    public boolean isCritical() default false;
}
