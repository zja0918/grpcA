package com.eeepay.api.servers;

import com.eeepay.api.grpc.TestProto;
import com.eeepay.api.grpc.TestServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * Created by A on 2016/3/18.
 */
public class TestServiceImpl implements TestServiceGrpc.TestService {
    @Override
    public void getInfoRpc(TestProto.TestRequest request, StreamObserver<TestProto.TestResponse> responseObserver) {
        TestProto.TestResponse res = TestProto.TestResponse.newBuilder().setAgentLinkMail("").build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
}
