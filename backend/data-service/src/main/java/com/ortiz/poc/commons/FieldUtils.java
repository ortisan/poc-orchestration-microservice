package com.ortiz.poc.commons;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.StringValue;

public class FieldUtils {

    public static <T> T getOrNull(T value) {
        if (value != null) {
            return value;
        }
        return null;
    }

    public static StringValue getStringValue(String value) {
        return getOrNull(value) != null ? StringValue.of(getOrNull(value)): StringValue.getDefaultInstance();
    }

    public static Int32Value getInteger32Value(Integer value) {
        return getOrNull(value) != null ? Int32Value.of(getOrNull(value)): Int32Value.getDefaultInstance();
    }

    public static Int64Value getInteger64Value(Long value) {
        return getOrNull(value) != null ? Int64Value.of(getOrNull(value)): Int64Value.getDefaultInstance();
    }

    public static BoolValue getBooleanValue(Boolean value) {
        return getOrNull(value) != null ? BoolValue.of(getOrNull(value)): BoolValue.getDefaultInstance();
    }

}
