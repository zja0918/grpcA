package com.eeepay.api.clients;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.eeepay.api.grpc.AgentSerProto.AgentRequest;
import com.eeepay.api.grpc.AgentSerProto.AgentResponse;
import com.eeepay.api.grpc.AgentServiceGrpc;
import com.eeepay.api.utils.Constants;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AgentClient {
	private static final Logger logger = Logger.getLogger(AgentClient.class.getName());
	private final ManagedChannel channel;
	private final AgentServiceGrpc.AgentServiceBlockingStub blockStub;
	private final AgentServiceGrpc.AgentServiceStub stub;
	public AgentClient(String host, int port) {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
		blockStub = AgentServiceGrpc.newBlockingStub(channel);
		stub = AgentServiceGrpc.newStub(channel);
	}
	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	public void getAgentInfo(){
		AgentRequest request = AgentRequest.newBuilder().setAgentLinkMail("client@client.com").build();
		AgentResponse response = blockStub.getAgentInfoRpc(request);
		System.out.println("服务器返回："+response.getAgentLinkMail());
	}
	public static void main(String[] args) {
		try {
			AgentClient client = new AgentClient(Constants.API_IP, Constants.API_PORT);
			client.getAgentInfo();
			client.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
