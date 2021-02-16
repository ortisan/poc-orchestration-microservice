package com.ortiz.grpc.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.31.0)",
    comments = "Source: data-service.proto")
public final class DataServiceGrpc {

  private DataServiceGrpc() {}

  public static final String SERVICE_NAME = "services.DataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.GetPersonRequest,
      com.ortiz.grpc.services.Person> getGetPersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPerson",
      requestType = com.ortiz.grpc.services.GetPersonRequest.class,
      responseType = com.ortiz.grpc.services.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.GetPersonRequest,
      com.ortiz.grpc.services.Person> getGetPersonMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.GetPersonRequest, com.ortiz.grpc.services.Person> getGetPersonMethod;
    if ((getGetPersonMethod = DataServiceGrpc.getGetPersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetPersonMethod = DataServiceGrpc.getGetPersonMethod) == null) {
          DataServiceGrpc.getGetPersonMethod = getGetPersonMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.GetPersonRequest, com.ortiz.grpc.services.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.GetPersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("GetPerson"))
              .build();
        }
      }
    }
    return getGetPersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getValidateSavePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateSavePerson",
      requestType = com.ortiz.grpc.services.Person.class,
      responseType = com.ortiz.grpc.services.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getValidateSavePersonMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person> getValidateSavePersonMethod;
    if ((getValidateSavePersonMethod = DataServiceGrpc.getValidateSavePersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getValidateSavePersonMethod = DataServiceGrpc.getValidateSavePersonMethod) == null) {
          DataServiceGrpc.getValidateSavePersonMethod = getValidateSavePersonMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateSavePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("ValidateSavePerson"))
              .build();
        }
      }
    }
    return getValidateSavePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getSavePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SavePerson",
      requestType = com.ortiz.grpc.services.Person.class,
      responseType = com.ortiz.grpc.services.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getSavePersonMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person> getSavePersonMethod;
    if ((getSavePersonMethod = DataServiceGrpc.getSavePersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getSavePersonMethod = DataServiceGrpc.getSavePersonMethod) == null) {
          DataServiceGrpc.getSavePersonMethod = getSavePersonMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SavePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("SavePerson"))
              .build();
        }
      }
    }
    return getSavePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getUndoSavePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndoSavePerson",
      requestType = com.ortiz.grpc.services.Person.class,
      responseType = com.ortiz.grpc.services.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getUndoSavePersonMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person> getUndoSavePersonMethod;
    if ((getUndoSavePersonMethod = DataServiceGrpc.getUndoSavePersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUndoSavePersonMethod = DataServiceGrpc.getUndoSavePersonMethod) == null) {
          DataServiceGrpc.getUndoSavePersonMethod = getUndoSavePersonMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndoSavePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("UndoSavePerson"))
              .build();
        }
      }
    }
    return getUndoSavePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getValidateUpdatePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateUpdatePerson",
      requestType = com.ortiz.grpc.services.Person.class,
      responseType = com.ortiz.grpc.services.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getValidateUpdatePersonMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person> getValidateUpdatePersonMethod;
    if ((getValidateUpdatePersonMethod = DataServiceGrpc.getValidateUpdatePersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getValidateUpdatePersonMethod = DataServiceGrpc.getValidateUpdatePersonMethod) == null) {
          DataServiceGrpc.getValidateUpdatePersonMethod = getValidateUpdatePersonMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateUpdatePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("ValidateUpdatePerson"))
              .build();
        }
      }
    }
    return getValidateUpdatePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getUpdatePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePerson",
      requestType = com.ortiz.grpc.services.Person.class,
      responseType = com.ortiz.grpc.services.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getUpdatePersonMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person> getUpdatePersonMethod;
    if ((getUpdatePersonMethod = DataServiceGrpc.getUpdatePersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUpdatePersonMethod = DataServiceGrpc.getUpdatePersonMethod) == null) {
          DataServiceGrpc.getUpdatePersonMethod = getUpdatePersonMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("UpdatePerson"))
              .build();
        }
      }
    }
    return getUpdatePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getUndoUpdatePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndoUpdatePerson",
      requestType = com.ortiz.grpc.services.Person.class,
      responseType = com.ortiz.grpc.services.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person,
      com.ortiz.grpc.services.Person> getUndoUpdatePersonMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person> getUndoUpdatePersonMethod;
    if ((getUndoUpdatePersonMethod = DataServiceGrpc.getUndoUpdatePersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUndoUpdatePersonMethod = DataServiceGrpc.getUndoUpdatePersonMethod) == null) {
          DataServiceGrpc.getUndoUpdatePersonMethod = getUndoUpdatePersonMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.Person, com.ortiz.grpc.services.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndoUpdatePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("UndoUpdatePerson"))
              .build();
        }
      }
    }
    return getUndoUpdatePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.GetPhoneRequest,
      com.ortiz.grpc.services.Phone> getGetPhoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPhone",
      requestType = com.ortiz.grpc.services.GetPhoneRequest.class,
      responseType = com.ortiz.grpc.services.Phone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.GetPhoneRequest,
      com.ortiz.grpc.services.Phone> getGetPhoneMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.GetPhoneRequest, com.ortiz.grpc.services.Phone> getGetPhoneMethod;
    if ((getGetPhoneMethod = DataServiceGrpc.getGetPhoneMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetPhoneMethod = DataServiceGrpc.getGetPhoneMethod) == null) {
          DataServiceGrpc.getGetPhoneMethod = getGetPhoneMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.GetPhoneRequest, com.ortiz.grpc.services.Phone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPhone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.GetPhoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Phone.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("GetPhone"))
              .build();
        }
      }
    }
    return getGetPhoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.Phone,
      com.ortiz.grpc.services.Phone> getSavePhoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SavePhone",
      requestType = com.ortiz.grpc.services.Phone.class,
      responseType = com.ortiz.grpc.services.Phone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.Phone,
      com.ortiz.grpc.services.Phone> getSavePhoneMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.Phone, com.ortiz.grpc.services.Phone> getSavePhoneMethod;
    if ((getSavePhoneMethod = DataServiceGrpc.getSavePhoneMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getSavePhoneMethod = DataServiceGrpc.getSavePhoneMethod) == null) {
          DataServiceGrpc.getSavePhoneMethod = getSavePhoneMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.Phone, com.ortiz.grpc.services.Phone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SavePhone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Phone.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Phone.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("SavePhone"))
              .build();
        }
      }
    }
    return getSavePhoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.Phone,
      com.ortiz.grpc.services.Phone> getUpdatePhoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePhone",
      requestType = com.ortiz.grpc.services.Phone.class,
      responseType = com.ortiz.grpc.services.Phone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.Phone,
      com.ortiz.grpc.services.Phone> getUpdatePhoneMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.Phone, com.ortiz.grpc.services.Phone> getUpdatePhoneMethod;
    if ((getUpdatePhoneMethod = DataServiceGrpc.getUpdatePhoneMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUpdatePhoneMethod = DataServiceGrpc.getUpdatePhoneMethod) == null) {
          DataServiceGrpc.getUpdatePhoneMethod = getUpdatePhoneMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.Phone, com.ortiz.grpc.services.Phone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePhone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Phone.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.Phone.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("UpdatePhone"))
              .build();
        }
      }
    }
    return getUpdatePhoneMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceStub>() {
        @java.lang.Override
        public DataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceStub(channel, callOptions);
        }
      };
    return DataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub>() {
        @java.lang.Override
        public DataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceBlockingStub(channel, callOptions);
        }
      };
    return DataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub>() {
        @java.lang.Override
        public DataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceFutureStub(channel, callOptions);
        }
      };
    return DataServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DataServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPerson(com.ortiz.grpc.services.GetPersonRequest request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPersonMethod(), responseObserver);
    }

    /**
     */
    public void validateSavePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnimplementedUnaryCall(getValidateSavePersonMethod(), responseObserver);
    }

    /**
     */
    public void savePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnimplementedUnaryCall(getSavePersonMethod(), responseObserver);
    }

    /**
     */
    public void undoSavePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnimplementedUnaryCall(getUndoSavePersonMethod(), responseObserver);
    }

    /**
     */
    public void validateUpdatePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnimplementedUnaryCall(getValidateUpdatePersonMethod(), responseObserver);
    }

    /**
     */
    public void updatePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdatePersonMethod(), responseObserver);
    }

    /**
     */
    public void undoUpdatePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnimplementedUnaryCall(getUndoUpdatePersonMethod(), responseObserver);
    }

    /**
     */
    public void getPhone(com.ortiz.grpc.services.GetPhoneRequest request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Phone> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPhoneMethod(), responseObserver);
    }

    /**
     */
    public void savePhone(com.ortiz.grpc.services.Phone request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Phone> responseObserver) {
      asyncUnimplementedUnaryCall(getSavePhoneMethod(), responseObserver);
    }

    /**
     */
    public void updatePhone(com.ortiz.grpc.services.Phone request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Phone> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdatePhoneMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPersonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.GetPersonRequest,
                com.ortiz.grpc.services.Person>(
                  this, METHODID_GET_PERSON)))
          .addMethod(
            getValidateSavePersonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.Person,
                com.ortiz.grpc.services.Person>(
                  this, METHODID_VALIDATE_SAVE_PERSON)))
          .addMethod(
            getSavePersonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.Person,
                com.ortiz.grpc.services.Person>(
                  this, METHODID_SAVE_PERSON)))
          .addMethod(
            getUndoSavePersonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.Person,
                com.ortiz.grpc.services.Person>(
                  this, METHODID_UNDO_SAVE_PERSON)))
          .addMethod(
            getValidateUpdatePersonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.Person,
                com.ortiz.grpc.services.Person>(
                  this, METHODID_VALIDATE_UPDATE_PERSON)))
          .addMethod(
            getUpdatePersonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.Person,
                com.ortiz.grpc.services.Person>(
                  this, METHODID_UPDATE_PERSON)))
          .addMethod(
            getUndoUpdatePersonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.Person,
                com.ortiz.grpc.services.Person>(
                  this, METHODID_UNDO_UPDATE_PERSON)))
          .addMethod(
            getGetPhoneMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.GetPhoneRequest,
                com.ortiz.grpc.services.Phone>(
                  this, METHODID_GET_PHONE)))
          .addMethod(
            getSavePhoneMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.Phone,
                com.ortiz.grpc.services.Phone>(
                  this, METHODID_SAVE_PHONE)))
          .addMethod(
            getUpdatePhoneMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.Phone,
                com.ortiz.grpc.services.Phone>(
                  this, METHODID_UPDATE_PHONE)))
          .build();
    }
  }

  /**
   */
  public static final class DataServiceStub extends io.grpc.stub.AbstractAsyncStub<DataServiceStub> {
    private DataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPerson(com.ortiz.grpc.services.GetPersonRequest request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateSavePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidateSavePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void savePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSavePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void undoSavePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUndoSavePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateUpdatePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidateUpdatePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdatePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void undoUpdatePerson(com.ortiz.grpc.services.Person request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUndoUpdatePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPhone(com.ortiz.grpc.services.GetPhoneRequest request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Phone> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPhoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void savePhone(com.ortiz.grpc.services.Phone request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Phone> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSavePhoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePhone(com.ortiz.grpc.services.Phone request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Phone> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdatePhoneMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataServiceBlockingStub> {
    private DataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ortiz.grpc.services.Person getPerson(com.ortiz.grpc.services.GetPersonRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.Person validateSavePerson(com.ortiz.grpc.services.Person request) {
      return blockingUnaryCall(
          getChannel(), getValidateSavePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.Person savePerson(com.ortiz.grpc.services.Person request) {
      return blockingUnaryCall(
          getChannel(), getSavePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.Person undoSavePerson(com.ortiz.grpc.services.Person request) {
      return blockingUnaryCall(
          getChannel(), getUndoSavePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.Person validateUpdatePerson(com.ortiz.grpc.services.Person request) {
      return blockingUnaryCall(
          getChannel(), getValidateUpdatePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.Person updatePerson(com.ortiz.grpc.services.Person request) {
      return blockingUnaryCall(
          getChannel(), getUpdatePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.Person undoUpdatePerson(com.ortiz.grpc.services.Person request) {
      return blockingUnaryCall(
          getChannel(), getUndoUpdatePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.Phone getPhone(com.ortiz.grpc.services.GetPhoneRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPhoneMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.Phone savePhone(com.ortiz.grpc.services.Phone request) {
      return blockingUnaryCall(
          getChannel(), getSavePhoneMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.Phone updatePhone(com.ortiz.grpc.services.Phone request) {
      return blockingUnaryCall(
          getChannel(), getUpdatePhoneMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataServiceFutureStub> {
    private DataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Person> getPerson(
        com.ortiz.grpc.services.GetPersonRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Person> validateSavePerson(
        com.ortiz.grpc.services.Person request) {
      return futureUnaryCall(
          getChannel().newCall(getValidateSavePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Person> savePerson(
        com.ortiz.grpc.services.Person request) {
      return futureUnaryCall(
          getChannel().newCall(getSavePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Person> undoSavePerson(
        com.ortiz.grpc.services.Person request) {
      return futureUnaryCall(
          getChannel().newCall(getUndoSavePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Person> validateUpdatePerson(
        com.ortiz.grpc.services.Person request) {
      return futureUnaryCall(
          getChannel().newCall(getValidateUpdatePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Person> updatePerson(
        com.ortiz.grpc.services.Person request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdatePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Person> undoUpdatePerson(
        com.ortiz.grpc.services.Person request) {
      return futureUnaryCall(
          getChannel().newCall(getUndoUpdatePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Phone> getPhone(
        com.ortiz.grpc.services.GetPhoneRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPhoneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Phone> savePhone(
        com.ortiz.grpc.services.Phone request) {
      return futureUnaryCall(
          getChannel().newCall(getSavePhoneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.Phone> updatePhone(
        com.ortiz.grpc.services.Phone request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdatePhoneMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PERSON = 0;
  private static final int METHODID_VALIDATE_SAVE_PERSON = 1;
  private static final int METHODID_SAVE_PERSON = 2;
  private static final int METHODID_UNDO_SAVE_PERSON = 3;
  private static final int METHODID_VALIDATE_UPDATE_PERSON = 4;
  private static final int METHODID_UPDATE_PERSON = 5;
  private static final int METHODID_UNDO_UPDATE_PERSON = 6;
  private static final int METHODID_GET_PHONE = 7;
  private static final int METHODID_SAVE_PHONE = 8;
  private static final int METHODID_UPDATE_PHONE = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PERSON:
          serviceImpl.getPerson((com.ortiz.grpc.services.GetPersonRequest) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person>) responseObserver);
          break;
        case METHODID_VALIDATE_SAVE_PERSON:
          serviceImpl.validateSavePerson((com.ortiz.grpc.services.Person) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person>) responseObserver);
          break;
        case METHODID_SAVE_PERSON:
          serviceImpl.savePerson((com.ortiz.grpc.services.Person) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person>) responseObserver);
          break;
        case METHODID_UNDO_SAVE_PERSON:
          serviceImpl.undoSavePerson((com.ortiz.grpc.services.Person) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person>) responseObserver);
          break;
        case METHODID_VALIDATE_UPDATE_PERSON:
          serviceImpl.validateUpdatePerson((com.ortiz.grpc.services.Person) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person>) responseObserver);
          break;
        case METHODID_UPDATE_PERSON:
          serviceImpl.updatePerson((com.ortiz.grpc.services.Person) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person>) responseObserver);
          break;
        case METHODID_UNDO_UPDATE_PERSON:
          serviceImpl.undoUpdatePerson((com.ortiz.grpc.services.Person) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Person>) responseObserver);
          break;
        case METHODID_GET_PHONE:
          serviceImpl.getPhone((com.ortiz.grpc.services.GetPhoneRequest) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Phone>) responseObserver);
          break;
        case METHODID_SAVE_PHONE:
          serviceImpl.savePhone((com.ortiz.grpc.services.Phone) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Phone>) responseObserver);
          break;
        case METHODID_UPDATE_PHONE:
          serviceImpl.updatePhone((com.ortiz.grpc.services.Phone) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.Phone>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ortiz.grpc.services.DataServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataService");
    }
  }

  private static final class DataServiceFileDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier {
    DataServiceFileDescriptorSupplier() {}
  }

  private static final class DataServiceMethodDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataServiceFileDescriptorSupplier())
              .addMethod(getGetPersonMethod())
              .addMethod(getValidateSavePersonMethod())
              .addMethod(getSavePersonMethod())
              .addMethod(getUndoSavePersonMethod())
              .addMethod(getValidateUpdatePersonMethod())
              .addMethod(getUpdatePersonMethod())
              .addMethod(getUndoUpdatePersonMethod())
              .addMethod(getGetPhoneMethod())
              .addMethod(getSavePhoneMethod())
              .addMethod(getUpdatePhoneMethod())
              .build();
        }
      }
    }
    return result;
  }
}
