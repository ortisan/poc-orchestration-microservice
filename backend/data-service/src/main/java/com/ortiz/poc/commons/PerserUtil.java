package com.ortiz.poc.commons;

import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

public class PerserUtil {

    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos())
                .atOffset(ZoneOffset.UTC)
                .toLocalDateTime();
    }

    public static Timestamp toTimestamp(LocalDateTime localDateTime) {
        LocalDateTime localDateTimeOptional = Optional.ofNullable(localDateTime).orElseGet(() -> LocalDateTime.of(1960, 1, 1, 0, 0));
        Instant instant = localDateTimeOptional.toInstant(ZoneOffset.UTC);
        return Timestamp.newBuilder().setSeconds(instant.getEpochSecond()).setNanos(instant.getNano()).build();
    }
}
