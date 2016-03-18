package com.eeepay.api.clients;

import com.eeepay.api.grpc.TestProto;
import com.eeepay.api.grpc.TestServiceGrpc;
import com.eeepay.api.utils.Constants;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by A on 2016/3/18.
 */
public class TestClient {
    private static final Logger logger = Logger.getLogger(TestClient.class.getName());
    private final ManagedChannel channel;
    private final TestServiceGrpc.TestServiceBlockingStub blockingStub;
    private final TestServiceGrpc.TestServiceFutureStub futureStub;
    private final TestServiceGrpc.TestServiceStub stub;

    public TestClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host,port).usePlaintext(true).build();
        blockingStub = TestServiceGrpc.newBlockingStub(channel);
        futureStub = TestServiceGrpc.newFutureStub(channel);
        stub = TestServiceGrpc.newStub(channel);
    }
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    public void testMethod(){
        TestProto.TestRequest request = TestProto.TestRequest.newBuilder().setAgentLinkMail("client@client.com").build();
        TestProto.TestResponse response = blockingStub.getInfoRpc(request);
        System.out.println(request +"<>"+response);
    }
    public static void main(String[] args) throws InterruptedException {
        TestClient client = new TestClient(Constants.API_IP,Constants.API_PORT);
        client.testMethod();
        client.shutdown();
    }
}
