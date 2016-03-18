package com.eeepay.api.servers;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eeepay.api.grpc.AgentServiceGrpc;
import com.eeepay.api.utils.Constants;
import com.z.grpc.dev.DevDemoServiceGrpc;
import com.z.grpc.domain.ManagerServiceGrpc;
import com.z.grpc.domain.ManagerServiceGrpc.ManagerService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MyServer {
	private static final Logger logger = Logger.getLogger(MyServer.class.getName());

	private Server server;

	private void start(String method) throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println(ac.getBean(AgentServiceImpl.class));
		ServerBuilder serverBuilder = ServerBuilder.forPort(Constants.API_PORT);
		//绑定服务1
		serverBuilder.addService(AgentServiceGrpc.bindService(ac.getBean(AgentServiceImpl.class)));
		serverBuilder.addService(DevDemoServiceGrpc.bindService(ac.getBean(AgentServiceImpl.class)));
		serverBuilder.addService(ManagerServiceGrpc.bindService(ac.getBean(AgentServiceImpl.class)));
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
