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
      Person> getGetPersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPerson",
      requestType = GetPersonRequest.class,
      responseType = Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetPersonRequest,
      Person> getGetPersonMethod() {
    io.grpc.MethodDescriptor<GetPersonRequest, Person> getGetPersonMethod;
    if ((getGetPersonMethod = DataServiceGrpc.getGetPersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetPersonMethod = DataServiceGrpc.getGetPersonMethod) == null) {
          DataServiceGrpc.getGetPersonMethod = getGetPersonMethod =
              io.grpc.MethodDescriptor.<GetPersonRequest, Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetPersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("GetPerson"))
              .build();
        }
      }
    }
    return getGetPersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Person,
      Person> getSavePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SavePerson",
      requestType = Person.class,
      responseType = Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Person,
      Person> getSavePersonMethod() {
    io.grpc.MethodDescriptor<Person, Person> getSavePersonMethod;
    if ((getSavePersonMethod = DataServiceGrpc.getSavePersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getSavePersonMethod = DataServiceGrpc.getSavePersonMethod) == null) {
          DataServiceGrpc.getSavePersonMethod = getSavePersonMethod =
              io.grpc.MethodDescriptor.<Person, Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SavePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("SavePerson"))
              .build();
        }
      }
    }
    return getSavePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Person,
      Person> getUpdatePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePerson",
      requestType = Person.class,
      responseType = Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Person,
      Person> getUpdatePersonMethod() {
    io.grpc.MethodDescriptor<Person, Person> getUpdatePersonMethod;
    if ((getUpdatePersonMethod = DataServiceGrpc.getUpdatePersonMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUpdatePersonMethod = DataServiceGrpc.getUpdatePersonMethod) == null) {
          DataServiceGrpc.getUpdatePersonMethod = getUpdatePersonMethod =
              io.grpc.MethodDescriptor.<Person, Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Person.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("UpdatePerson"))
              .build();
        }
      }
    }
    return getUpdatePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetPhoneRequest,
      Phone> getGetPhoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPhone",
      requestType = GetPhoneRequest.class,
      responseType = Phone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetPhoneRequest,
      Phone> getGetPhoneMethod() {
    io.grpc.MethodDescriptor<GetPhoneRequest, Phone> getGetPhoneMethod;
    if ((getGetPhoneMethod = DataServiceGrpc.getGetPhoneMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetPhoneMethod = DataServiceGrpc.getGetPhoneMethod) == null) {
          DataServiceGrpc.getGetPhoneMethod = getGetPhoneMethod =
              io.grpc.MethodDescriptor.<GetPhoneRequest, Phone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPhone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetPhoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Phone.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("GetPhone"))
              .build();
        }
      }
    }
    return getGetPhoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Phone,
      Phone> getSavePhoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SavePhone",
      requestType = Phone.class,
      responseType = Phone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Phone,
      Phone> getSavePhoneMethod() {
    io.grpc.MethodDescriptor<Phone, Phone> getSavePhoneMethod;
    if ((getSavePhoneMethod = DataServiceGrpc.getSavePhoneMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getSavePhoneMethod = DataServiceGrpc.getSavePhoneMethod) == null) {
          DataServiceGrpc.getSavePhoneMethod = getSavePhoneMethod =
              io.grpc.MethodDescriptor.<Phone, Phone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SavePhone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Phone.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Phone.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("SavePhone"))
              .build();
        }
      }
    }
    return getSavePhoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Phone,
      Phone> getUpdatePhoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePhone",
      requestType = Phone.class,
      responseType = Phone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Phone,
      Phone> getUpdatePhoneMethod() {
    io.grpc.MethodDescriptor<Phone, Phone> getUpdatePhoneMethod;
    if ((getUpdatePhoneMethod = DataServiceGrpc.getUpdatePhoneMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUpdatePhoneMethod = DataServiceGrpc.getUpdatePhoneMethod) == null) {
          DataServiceGrpc.getUpdatePhoneMethod = getUpdatePhoneMethod =
              io.grpc.MethodDescriptor.<Phone, Phone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePhone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Phone.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Phone.getDefaultInstance()))
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
                          io.grpc.stub.StreamObserver<Person> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPersonMethod(), responseObserver);
    }

    /**
     */
    public void savePerson(Person request,
                           io.grpc.stub.StreamObserver<Person> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSavePersonMethod(), responseObserver);
    }

    /**
     */
    public void updatePerson(Person request,
                             io.grpc.stub.StreamObserver<Person> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePersonMethod(), responseObserver);
    }

    /**
     */
    public void getPhone(GetPhoneRequest request,
                         io.grpc.stub.StreamObserver<Phone> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPhoneMethod(), responseObserver);
    }

    /**
     */
    public void savePhone(Phone request,
                          io.grpc.stub.StreamObserver<Phone> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSavePhoneMethod(), responseObserver);
    }

    /**
     */
    public void updatePhone(Phone request,
                            io.grpc.stub.StreamObserver<Phone> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePhoneMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPersonMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetPersonRequest,
                Person>(
                  this, METHODID_GET_PERSON)))
          .addMethod(
            getSavePersonMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Person,
                Person>(
                  this, METHODID_SAVE_PERSON)))
          .addMethod(
            getUpdatePersonMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Person,
                Person>(
                  this, METHODID_UPDATE_PERSON)))
          .addMethod(
            getGetPhoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GetPhoneRequest,
                Phone>(
                  this, METHODID_GET_PHONE)))
          .addMethod(
            getSavePhoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Phone,
                Phone>(
                  this, METHODID_SAVE_PHONE)))
          .addMethod(
            getUpdatePhoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Phone,
                Phone>(
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

    @Override
    protected DataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPerson(GetPersonRequest request,
                          io.grpc.stub.StreamObserver<Person> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void savePerson(Person request,
                           io.grpc.stub.StreamObserver<Person> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSavePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePerson(Person request,
                             io.grpc.stub.StreamObserver<Person> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPhone(GetPhoneRequest request,
                         io.grpc.stub.StreamObserver<Phone> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPhoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void savePhone(Phone request,
                          io.grpc.stub.StreamObserver<Phone> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSavePhoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePhone(Phone request,
                            io.grpc.stub.StreamObserver<Phone> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
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

    @Override
    protected DataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Person getPerson(GetPersonRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public Person savePerson(Person request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSavePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public Person updatePerson(Person request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public Phone getPhone(GetPhoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPhoneMethod(), getCallOptions(), request);
    }

    /**
     */
    public Phone savePhone(Phone request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSavePhoneMethod(), getCallOptions(), request);
    }

    /**
     */
    public Phone updatePhone(Phone request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
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

    @Override
    protected DataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Person> getPerson(
        GetPersonRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Person> savePerson(
        Person request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSavePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Person> updatePerson(
        Person request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Phone> getPhone(
        GetPhoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPhoneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Phone> savePhone(
        Phone request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSavePhoneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Phone> updatePhone(
        Phone request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePhoneMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PERSON = 0;
  private static final int METHODID_SAVE_PERSON = 1;
  private static final int METHODID_UPDATE_PERSON = 2;
  private static final int METHODID_GET_PHONE = 3;
  private static final int METHODID_SAVE_PHONE = 4;
  private static final int METHODID_UPDATE_PHONE = 5;

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
              (io.grpc.stub.StreamObserver<Person>) responseObserver);
          break;
        case METHODID_SAVE_PERSON:
          serviceImpl.savePerson((Person) request,
              (io.grpc.stub.StreamObserver<Person>) responseObserver);
          break;
        case METHODID_UPDATE_PERSON:
          serviceImpl.updatePerson((Person) request,
              (io.grpc.stub.StreamObserver<Person>) responseObserver);
          break;
        case METHODID_GET_PHONE:
          serviceImpl.getPhone((GetPhoneRequest) request,
              (io.grpc.stub.StreamObserver<Phone>) responseObserver);
          break;
        case METHODID_SAVE_PHONE:
          serviceImpl.savePhone((Phone) request,
              (io.grpc.stub.StreamObserver<Phone>) responseObserver);
          break;
        case METHODID_UPDATE_PHONE:
          serviceImpl.updatePhone((Phone) request,
              (io.grpc.stub.StreamObserver<Phone>) responseObserver);
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
              .addMethod(getSavePersonMethod())
              .addMethod(getUpdatePersonMethod())
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
