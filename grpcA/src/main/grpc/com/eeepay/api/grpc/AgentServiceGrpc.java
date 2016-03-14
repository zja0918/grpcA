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
public class AgentServiceGrpc {

  private AgentServiceGrpc() {}

  public static final String SERVICE_NAME = "AgentService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<com.eeepay.api.grpc.AgentSerProto.AgentRequest,
      com.eeepay.api.grpc.AgentSerProto.AgentResponse> METHOD_GET_AGENT_INFO_RPC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "AgentService", "getAgentInfoRpc"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eeepay.api.grpc.AgentSerProto.AgentRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.eeepay.api.grpc.AgentSerProto.AgentResponse.getDefaultInstance()));

  public static AgentServiceStub newStub(io.grpc.Channel channel) {
    return new AgentServiceStub(channel);
  }

  public static AgentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AgentServiceBlockingStub(channel);
  }

  public static AgentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AgentServiceFutureStub(channel);
  }

  public static interface AgentService {

    public void getAgentInfoRpc(com.eeepay.api.grpc.AgentSerProto.AgentRequest request,
        io.grpc.stub.StreamObserver<com.eeepay.api.grpc.AgentSerProto.AgentResponse> responseObserver);
  }

  public static interface AgentServiceBlockingClient {

    public com.eeepay.api.grpc.AgentSerProto.AgentResponse getAgentInfoRpc(com.eeepay.api.grpc.AgentSerProto.AgentRequest request);
  }

  public static interface AgentServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<com.eeepay.api.grpc.AgentSerProto.AgentResponse> getAgentInfoRpc(
        com.eeepay.api.grpc.AgentSerProto.AgentRequest request);
  }

  public static class AgentServiceStub extends io.grpc.stub.AbstractStub<AgentServiceStub>
      implements AgentService {
    private AgentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AgentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AgentServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void getAgentInfoRpc(com.eeepay.api.grpc.AgentSerProto.AgentRequest request,
        io.grpc.stub.StreamObserver<com.eeepay.api.grpc.AgentSerProto.AgentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_AGENT_INFO_RPC, getCallOptions()), request, responseObserver);
    }
  }

  public static class AgentServiceBlockingStub extends io.grpc.stub.AbstractStub<AgentServiceBlockingStub>
      implements AgentServiceBlockingClient {
    private AgentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AgentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AgentServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.eeepay.api.grpc.AgentSerProto.AgentResponse getAgentInfoRpc(com.eeepay.api.grpc.AgentSerProto.AgentRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_AGENT_INFO_RPC, getCallOptions()), request);
    }
  }

  public static class AgentServiceFutureStub extends io.grpc.stub.AbstractStub<AgentServiceFutureStub>
      implements AgentServiceFutureClient {
    private AgentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AgentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AgentServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.eeepay.api.grpc.AgentSerProto.AgentResponse> getAgentInfoRpc(
        com.eeepay.api.grpc.AgentSerProto.AgentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_AGENT_INFO_RPC, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final AgentService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_GET_AGENT_INFO_RPC,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              com.eeepay.api.grpc.AgentSerProto.AgentRequest,
              com.eeepay.api.grpc.AgentSerProto.AgentResponse>() {
            @java.lang.Override
            public void invoke(
                com.eeepay.api.grpc.AgentSerProto.AgentRequest request,
                io.grpc.stub.StreamObserver<com.eeepay.api.grpc.AgentSerProto.AgentResponse> responseObserver) {
              serviceImpl.getAgentInfoRpc(request, responseObserver);
            }
          })).build();
  }
}
