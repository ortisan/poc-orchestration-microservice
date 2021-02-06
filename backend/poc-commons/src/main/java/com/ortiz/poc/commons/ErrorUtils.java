package com.ortiz.poc.commons;

import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageV3;
import com.google.rpc.Code;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;

public class ErrorUtils {

    public static StatusRuntimeException handleError(Exception exc, Code code, GeneratedMessageV3 request) {
        Status status = Status.newBuilder()
                .setCode(code.getNumber())
                .setMessage(exc.getMessage())
                .addDetails(Any.pack(request))
                .build();
        return StatusProto.toStatusRuntimeException(status);
    }
}
