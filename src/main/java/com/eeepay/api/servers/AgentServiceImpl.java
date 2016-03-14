package com.eeepay.api.servers;

import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.eeepay.api.grpc.AgentSerProto.AgentRequest;
import com.eeepay.api.grpc.AgentSerProto.AgentResponse;
import com.eeepay.api.grpc.AgentServiceGrpc.AgentService;

import io.grpc.stub.StreamObserver;

public class AgentServiceImpl implements AgentService {
	private static final Logger logger = Logger.getLogger(AgentServiceImpl.class.getName());

	@Override
	public void getAgentInfoRpc(AgentRequest request, StreamObserver<AgentResponse> responseObserver) {
		System.out.println("客户端上送："+request.getAgentLinkMail());
		String mail = request.getAgentLinkMail();
		if(StringUtils.isEmpty(mail) || mail.indexOf("@")<1){
			mail = "请输入正确格式的email";
		}else{
			mail = "server@server.com.cn";
		}
		AgentResponse res = AgentResponse.newBuilder().setAgentLinkMail(mail).build(); 
		responseObserver.onNext(res);
		responseObserver.onCompleted();
	}
}
