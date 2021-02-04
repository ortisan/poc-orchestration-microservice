package com.ortiz.grpc.services.vfs;

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
    comments = "Source: validation-fields-service.proto")
public final class ValidationFieldsServiceGrpc {

  private ValidationFieldsServiceGrpc() {}

  public static final String SERVICE_NAME = "services.ValidationFieldsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.vfs.VerifiedFields,
      com.ortiz.grpc.services.vfs.VerifiedFields> getValidateFieldsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateFields",
      requestType = com.ortiz.grpc.services.vfs.VerifiedFields.class,
      responseType = com.ortiz.grpc.services.vfs.VerifiedFields.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.vfs.VerifiedFields,
      com.ortiz.grpc.services.vfs.VerifiedFields> getValidateFieldsMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.vfs.VerifiedFields, com.ortiz.grpc.services.vfs.VerifiedFields> getValidateFieldsMethod;
    if ((getValidateFieldsMethod = ValidationFieldsServiceGrpc.getValidateFieldsMethod) == null) {
      synchronized (ValidationFieldsServiceGrpc.class) {
        if ((getValidateFieldsMethod = ValidationFieldsServiceGrpc.getValidateFieldsMethod) == null) {
          ValidationFieldsServiceGrpc.getValidateFieldsMethod = getValidateFieldsMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.vfs.VerifiedFields, com.ortiz.grpc.services.vfs.VerifiedFields>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateFields"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.vfs.VerifiedFields.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.vfs.VerifiedFields.getDefaultInstance()))
              .setSchemaDescriptor(new ValidationFieldsServiceMethodDescriptorSupplier("ValidateFields"))
              .build();
        }
      }
    }
    return getValidateFieldsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ortiz.grpc.services.vfs.VerifiedFields,
      com.ortiz.grpc.services.vfs.VerifiedFields> getSaveVerifiedFieldsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveVerifiedFields",
      requestType = com.ortiz.grpc.services.vfs.VerifiedFields.class,
      responseType = com.ortiz.grpc.services.vfs.VerifiedFields.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ortiz.grpc.services.vfs.VerifiedFields,
      com.ortiz.grpc.services.vfs.VerifiedFields> getSaveVerifiedFieldsMethod() {
    io.grpc.MethodDescriptor<com.ortiz.grpc.services.vfs.VerifiedFields, com.ortiz.grpc.services.vfs.VerifiedFields> getSaveVerifiedFieldsMethod;
    if ((getSaveVerifiedFieldsMethod = ValidationFieldsServiceGrpc.getSaveVerifiedFieldsMethod) == null) {
      synchronized (ValidationFieldsServiceGrpc.class) {
        if ((getSaveVerifiedFieldsMethod = ValidationFieldsServiceGrpc.getSaveVerifiedFieldsMethod) == null) {
          ValidationFieldsServiceGrpc.getSaveVerifiedFieldsMethod = getSaveVerifiedFieldsMethod =
              io.grpc.MethodDescriptor.<com.ortiz.grpc.services.vfs.VerifiedFields, com.ortiz.grpc.services.vfs.VerifiedFields>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SaveVerifiedFields"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.vfs.VerifiedFields.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ortiz.grpc.services.vfs.VerifiedFields.getDefaultInstance()))
              .setSchemaDescriptor(new ValidationFieldsServiceMethodDescriptorSupplier("SaveVerifiedFields"))
              .build();
        }
      }
    }
    return getSaveVerifiedFieldsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ValidationFieldsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ValidationFieldsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ValidationFieldsServiceStub>() {
        @java.lang.Override
        public ValidationFieldsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ValidationFieldsServiceStub(channel, callOptions);
        }
      };
    return ValidationFieldsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ValidationFieldsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ValidationFieldsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ValidationFieldsServiceBlockingStub>() {
        @java.lang.Override
        public ValidationFieldsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ValidationFieldsServiceBlockingStub(channel, callOptions);
        }
      };
    return ValidationFieldsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ValidationFieldsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ValidationFieldsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ValidationFieldsServiceFutureStub>() {
        @java.lang.Override
        public ValidationFieldsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ValidationFieldsServiceFutureStub(channel, callOptions);
        }
      };
    return ValidationFieldsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ValidationFieldsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void validateFields(com.ortiz.grpc.services.vfs.VerifiedFields request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.vfs.VerifiedFields> responseObserver) {
      asyncUnimplementedUnaryCall(getValidateFieldsMethod(), responseObserver);
    }

    /**
     */
    public void saveVerifiedFields(com.ortiz.grpc.services.vfs.VerifiedFields request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.vfs.VerifiedFields> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveVerifiedFieldsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getValidateFieldsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.vfs.VerifiedFields,
                com.ortiz.grpc.services.vfs.VerifiedFields>(
                  this, METHODID_VALIDATE_FIELDS)))
          .addMethod(
            getSaveVerifiedFieldsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ortiz.grpc.services.vfs.VerifiedFields,
                com.ortiz.grpc.services.vfs.VerifiedFields>(
                  this, METHODID_SAVE_VERIFIED_FIELDS)))
          .build();
    }
  }

  /**
   */
  public static final class ValidationFieldsServiceStub extends io.grpc.stub.AbstractAsyncStub<ValidationFieldsServiceStub> {
    private ValidationFieldsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ValidationFieldsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ValidationFieldsServiceStub(channel, callOptions);
    }

    /**
     */
    public void validateFields(com.ortiz.grpc.services.vfs.VerifiedFields request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.vfs.VerifiedFields> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidateFieldsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveVerifiedFields(com.ortiz.grpc.services.vfs.VerifiedFields request,
        io.grpc.stub.StreamObserver<com.ortiz.grpc.services.vfs.VerifiedFields> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveVerifiedFieldsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ValidationFieldsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ValidationFieldsServiceBlockingStub> {
    private ValidationFieldsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ValidationFieldsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ValidationFieldsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ortiz.grpc.services.vfs.VerifiedFields validateFields(com.ortiz.grpc.services.vfs.VerifiedFields request) {
      return blockingUnaryCall(
          getChannel(), getValidateFieldsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ortiz.grpc.services.vfs.VerifiedFields saveVerifiedFields(com.ortiz.grpc.services.vfs.VerifiedFields request) {
      return blockingUnaryCall(
          getChannel(), getSaveVerifiedFieldsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ValidationFieldsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ValidationFieldsServiceFutureStub> {
    private ValidationFieldsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ValidationFieldsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ValidationFieldsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.vfs.VerifiedFields> validateFields(
        com.ortiz.grpc.services.vfs.VerifiedFields request) {
      return futureUnaryCall(
          getChannel().newCall(getValidateFieldsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ortiz.grpc.services.vfs.VerifiedFields> saveVerifiedFields(
        com.ortiz.grpc.services.vfs.VerifiedFields request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveVerifiedFieldsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VALIDATE_FIELDS = 0;
  private static final int METHODID_SAVE_VERIFIED_FIELDS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ValidationFieldsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ValidationFieldsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VALIDATE_FIELDS:
          serviceImpl.validateFields((com.ortiz.grpc.services.vfs.VerifiedFields) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.vfs.VerifiedFields>) responseObserver);
          break;
        case METHODID_SAVE_VERIFIED_FIELDS:
          serviceImpl.saveVerifiedFields((com.ortiz.grpc.services.vfs.VerifiedFields) request,
              (io.grpc.stub.StreamObserver<com.ortiz.grpc.services.vfs.VerifiedFields>) responseObserver);
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

  private static abstract class ValidationFieldsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ValidationFieldsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ortiz.grpc.services.vfs.ValidationFieldsServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ValidationFieldsService");
    }
  }

  private static final class ValidationFieldsServiceFileDescriptorSupplier
      extends ValidationFieldsServiceBaseDescriptorSupplier {
    ValidationFieldsServiceFileDescriptorSupplier() {}
  }

  private static final class ValidationFieldsServiceMethodDescriptorSupplier
      extends ValidationFieldsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ValidationFieldsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ValidationFieldsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ValidationFieldsServiceFileDescriptorSupplier())
              .addMethod(getValidateFieldsMethod())
              .addMethod(getSaveVerifiedFieldsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
