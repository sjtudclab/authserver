package cn.edu.sjtu.se.dclab.authserver.thrift;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.thrift.server.*;
import org.apache.thrift.transport.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.edu.sjtu.se.dclab.service_management.Content;
import cn.edu.sjtu.se.dclab.service_management.ServiceManager;

public class AuthServer {
	
	private ClassPathXmlApplicationContext context;
	private int port;
	private String nodeName;

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

	
	public AuthServer(ClassPathXmlApplicationContext ctx, int p, String nm) {
		context = ctx;
		port = p;
		nodeName = nm;
	}
		
	public void startServer() {
		AuthService authService = context.getBean(AuthService.class);
		ServiceManager manager = ServiceManager.getInstance();

		TServer server = null;
		try {
			String localIp = InetAddress.getLocalHost().getHostAddress();
			Content content = new ASContent(localIp, port);

			manager.registe(nodeName, content, null, null);

			TServerSocket serverTransport = new TServerSocket(port);
			Auth.Processor<AuthService> processor = new Auth.Processor<AuthService>(authService);
			server = new TThreadPoolServer(new TThreadPoolServer.Args(
					serverTransport).processor(processor));
			System.out.println("Starting server on port 7911 ...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
			manager.remove(nodeName);
			return;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return;
		}
		
	}
	
	public void removeZkNode() {
		ServiceManager manager = ServiceManager.getInstance();
		manager.remove(nodeName);
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		int port = 7911;
		String nodeName = "/authService";
		AuthServer authServer = new AuthServer(ctx, port, nodeName);
		authServer.removeZkNode();
		authServer.startServer();
		
	}

}
