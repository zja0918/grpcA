package com.eeepay.api.servers;

import com.eeepay.api.grpc.TestProto;
import com.eeepay.api.grpc.TestProto.ListResponse;
import com.eeepay.api.grpc.TestProto.TestRequest;
import com.eeepay.api.grpc.TestProto.TestResponse;
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
        TestProto.TestResponse res = TestProto.TestResponse.newBuilder()
        		.setAgentLinkMail("service@service.com")
        		.build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

	@Override
	public void getListInfoRpc(TestRequest request, StreamObserver<ListResponse> responseObserver) {
		ListResponse listRes = ListResponse.newBuilder()
				.setRpcHead("温馨提示").setRpcStatus("").setRpcMsg("访问成功")
				.addListResponse(TestResponse.newBuilder().setAgentLinkMail("aaa@service.com").build())
				.addListResponse(TestResponse.newBuilder().setAgentLinkMail("bbb@service.com").build())
				.addListResponse(TestResponse.newBuilder().setAgentLinkMail("ccc@service.com").build())
				.addListResponse(TestResponse.newBuilder().setAgentLinkMail("ddd@service.com").build())
				.build();
        responseObserver.onNext(listRes);
        responseObserver.onCompleted();
	}
}
