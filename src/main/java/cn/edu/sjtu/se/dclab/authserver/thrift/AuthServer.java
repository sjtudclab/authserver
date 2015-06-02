package cn.edu.sjtu.se.dclab.authserver.thrift;

import org.apache.thrift.server.*;
import org.apache.thrift.transport.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AuthServer {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AuthService authService = ctx.getBean(AuthService.class);

		try {
			TServerSocket serverTransport = new TServerSocket(7911);
			Auth.Processor<AuthService> processor = new Auth.Processor<AuthService>(authService);
			TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(
					serverTransport).processor(processor));
			System.out.println("Starting server on port 7911 ...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

}
