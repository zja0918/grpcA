package com.eeepay.api.servers;
import com.eeepay.api.grpc.TestServiceGrpc;
import com.eeepay.api.utils.Constants;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class MyServer {
	private static final Logger logger = Logger.getLogger(MyServer.class.getName());

	private Server server;

	private void start() throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ServerBuilder serverBuilder = ServerBuilder.forPort(Constants.API_PORT);
		//绑定服务1
		serverBuilder.addService(TestServiceGrpc.bindService(ac.getBean(TestServiceImpl.class)));
		//启动服务
		server = serverBuilder.build().start();
		logger.info("\n\n服务端启动，监听端口： " + Constants.API_PORT);
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
		searchServer.start();
		searchServer.blockUntilShutdown();
	}

}
