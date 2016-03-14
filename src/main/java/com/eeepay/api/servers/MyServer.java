package com.eeepay.api.servers;

import java.util.logging.Logger;

import com.eeepay.api.grpc.AgentServiceGrpc;
import com.eeepay.api.utils.Constants;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MyServer {
	private static final Logger logger = Logger.getLogger(MyServer.class.getName());

	private Server server;

	private void start(String method) throws Exception {
		ServerBuilder serverBuilder = ServerBuilder.forPort(Constants.API_PORT);
		//绑定服务1
		serverBuilder.addService(AgentServiceGrpc.bindService(new AgentServiceImpl()));
		server = serverBuilder.build().start();
		logger.info("\n\n\n\n\n服务端启动，监听端口： " + Constants.API_PORT);
	}

	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	public static void main(String[] args) throws Exception {
		final MyServer searchServer = new MyServer();
		searchServer.start("myServer");
		searchServer.blockUntilShutdown();
	}

}
