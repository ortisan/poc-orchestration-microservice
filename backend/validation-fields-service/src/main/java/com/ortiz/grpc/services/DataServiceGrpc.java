package com.ortiz.grpc.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: data-service.proto")
public final class DataServiceGrpc {

  private DataServiceGrpc() {}

  public static final String SERVICE_NAME = "services.DataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GetPersonRequest,
      GetPersonResponse> getGetPersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPerson",
      requestType = GetPersonRequest.class,
      responseType = GetPersonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetPersonRequest,
      GetPersonResponse> getGetPersonMethod() {
    io.grpc.MethodDescriptor<GetPersonRequest, GetPersonResponse> getGetPersonMethod;
    if ((getGetPersonMethod = DataServiceGrpc.getGetPersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetPersonMethod = DataServiceGrpc.getGetPersonMethod) == null) {
          DataServiceGrpc.getGetPersonMethod = getGetPersonMethod =
              io.grpc.MethodDescriptor.<GetPersonRequest, GetPersonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetPersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetPersonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("GetPerson"))
              .build();
        }
      }
    }
    return getGetPersonMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceStub>() {
        @Override
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
        @Override
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
        @Override
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
    public void getPerson(GetPersonRequest request,
                          io.grpc.stub.StreamObserver<GetPersonResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPersonMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPersonMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetPersonRequest,
                GetPersonResponse>(
                  this, METHODID_GET_PERSON)))
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

    @Override
    protected DataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPerson(GetPersonRequest request,
                          io.grpc.stub.StreamObserver<GetPersonResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataServiceBlockingStub> {
    private DataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GetPersonResponse getPerson(GetPersonRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPersonMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataServiceFutureStub> {
    private DataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetPersonResponse> getPerson(
        GetPersonRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PERSON = 0;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PERSON:
          serviceImpl.getPerson((GetPersonRequest) request,
              (io.grpc.stub.StreamObserver<GetPersonResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
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

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DataServiceOuterClass.getDescriptor();
    }

    @Override
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

    @Override
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
              .build();
        }
      }
    }
    return result;
  }
}
