package cn.edu.sjtu.se.dclab.authserver.thrift;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.apache.thrift.server.*;
import org.apache.thrift.transport.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.edu.sjtu.se.dclab.authserver.utils.Constants;
import cn.edu.sjtu.se.dclab.service_management.Content;
import cn.edu.sjtu.se.dclab.service_management.ServiceManager;

public class AuthServer {
	
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
		AuthService authService = context.getBean(AuthService.class);
		ServiceManager manager = ServiceManager.getInstance();

		server = null;
		try {
			// register zookeeper node
			String localIp = Constants.THRIFT_SERVER_IP;
			Content content = new ASContent(localIp, port);
			String childName = UUID.randomUUID().toString().replace("-", "");
			manager.registe(nodeName, childName, content, null, null);

			// start a server
			TServerSocket serverTransport = new TServerSocket(port);
			Auth.Processor<AuthService> processor = new Auth.Processor<AuthService>(authService);
			server = new TThreadPoolServer(new TThreadPoolServer.Args(
					serverTransport).processor(processor));
			System.out.println("Starting server on port " + port + " ...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
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
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		int port = 7911;
		String nodeName = "/authService";
		AuthServer authServer = new AuthServer(ctx, port, nodeName);
		authServer.removeZkNode();
		authServer.startServer();
		
	}
	*/
}
