package com.eeepay.api.servers;

import com.eeepay.api.grpc.TestProto;
import com.eeepay.api.grpc.TestServiceGrpc.TestService;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

/**
 * Created by A on 2016/3/18.
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void getInfoRpc(TestProto.TestRequest request, StreamObserver<TestProto.TestResponse> responseObserver) {
        TestProto.TestResponse res = TestProto.TestResponse.newBuilder().setAgentLinkMail("service@service.com").build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
}
