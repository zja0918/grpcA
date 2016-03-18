package com.eeepay.api.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class TestServiceGrpc {

  private TestServiceGrpc() {}

  public static final String SERVICE_NAME = "TestService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.eeepay.api.grpc.TestProto.TestRequest,
      com.eeepay.api.grpc.TestProto.TestResponse> METHOD_GET_INFO_RPC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "TestService", "getInfoRpc"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eeepay.api.grpc.TestProto.TestRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eeepay.api.grpc.TestProto.TestResponse.getDefaultInstance()));

  public static TestServiceStub newStub(io.grpc.Channel channel) {
    return new TestServiceStub(channel);
  }

  public static TestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TestServiceBlockingStub(channel);
  }

  public static TestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TestServiceFutureStub(channel);
  }

  public static interface TestService {

    public void getInfoRpc(com.eeepay.api.grpc.TestProto.TestRequest request,
        io.grpc.stub.StreamObserver<com.eeepay.api.grpc.TestProto.TestResponse> responseObserver);
  }

  public static interface TestServiceBlockingClient {

    public com.eeepay.api.grpc.TestProto.TestResponse getInfoRpc(com.eeepay.api.grpc.TestProto.TestRequest request);
  }

  public static interface TestServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.eeepay.api.grpc.TestProto.TestResponse> getInfoRpc(
        com.eeepay.api.grpc.TestProto.TestRequest request);
  }

  public static class TestServiceStub extends io.grpc.stub.AbstractStub<TestServiceStub>
      implements TestService {
    private TestServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void getInfoRpc(com.eeepay.api.grpc.TestProto.TestRequest request,
        io.grpc.stub.StreamObserver<com.eeepay.api.grpc.TestProto.TestResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_INFO_RPC, getCallOptions()), request, responseObserver);
    }
  }

  public static class TestServiceBlockingStub extends io.grpc.stub.AbstractStub<TestServiceBlockingStub>
      implements TestServiceBlockingClient {
    private TestServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.eeepay.api.grpc.TestProto.TestResponse getInfoRpc(com.eeepay.api.grpc.TestProto.TestRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_INFO_RPC, getCallOptions()), request);
    }
  }

  public static class TestServiceFutureStub extends io.grpc.stub.AbstractStub<TestServiceFutureStub>
      implements TestServiceFutureClient {
    private TestServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.eeepay.api.grpc.TestProto.TestResponse> getInfoRpc(
        com.eeepay.api.grpc.TestProto.TestRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_INFO_RPC, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final TestService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_GET_INFO_RPC,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.eeepay.api.grpc.TestProto.TestRequest,
              com.eeepay.api.grpc.TestProto.TestResponse>() {
            @java.lang.Override
            public void invoke(
                com.eeepay.api.grpc.TestProto.TestRequest request,
                io.grpc.stub.StreamObserver<com.eeepay.api.grpc.TestProto.TestResponse> responseObserver) {
              serviceImpl.getInfoRpc(request, responseObserver);
            }
          })).build();
  }
}
