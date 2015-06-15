package cn.edu.sjtu.se.dclab.authserver.thrift;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.apache.thrift.server.*;
import org.apache.thrift.transport.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import cn.edu.sjtu.se.dclab.authserver.utils.Constants;
import cn.edu.sjtu.se.dclab.service_management.Content;
import cn.edu.sjtu.se.dclab.service_management.ServiceManager;

public class AuthServer {
	
	private Logger logger = LoggerFactory.getLogger(AuthServer.class);
	private ClassPathXmlApplicationContext context;
	private int port;
	private String nodeName;
	private TServer server;

	public ClassPathXmlApplicationContext getContext() {
		return context;
	}
	public void setContext(ClassPathXmlApplicationContext context) {
		this.context = context;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	
	public AuthServer(ClassPathXmlApplicationContext ctx) {
		context = ctx;
		port = Constants.THRIFT_SERVER_PORT;
		nodeName = Constants.THRIFT_SERVER_ROOTNAME;
	}
		
	public void startServer() {
		logger.info("startServer()");
		
		AuthService authService = context.getBean(AuthService.class);
		ServiceManager manager = ServiceManager.getInstance();

		server = null;
		try {
			// register zookeeper node
			String localIp = Constants.THRIFT_SERVER_IP;
			Content content = new ASContent(localIp, port);
			String childName = UUID.randomUUID().toString().replace("-", "");
			manager.registe(nodeName, childName, content, null, null);
			logger.info("register node done");
			
			// start a server
			TServerSocket serverTransport = new TServerSocket(port);
			Auth.Processor<AuthService> processor = new Auth.Processor<AuthService>(authService);
			server = new TThreadPoolServer(new TThreadPoolServer.Args(
					serverTransport).processor(processor));
			logger.info("Starting server on port " + port + " ...");
			server.serve();
			
		} catch (TTransportException e) {
			logger.info(e.getMessage());
			manager.remove(nodeName);
			return;
		}
		
	}
	
	public void stopServer() {
		server.stop();
	}
	
	public void removeZkNode() {
		ServiceManager manager = ServiceManager.getInstance();
		manager.remove(nodeName);
	}
	
	/*
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Resource resource = ctx.getResource("classpath:application.properties");

		Constants.init("E:\\workspace\\authserver\\src\\test\\resources\\application.properties");


		AuthServer authServer = new AuthServer(ctx);
		try {
			authServer.removeZkNode();
		} catch (RuntimeException ex) {
			// Normal case
			ex.printStackTrace();
		}
		authServer.startServer();
		
	}*/
	
}
