package cn.edu.sjtu.se.dclab.authserver.thrift;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuthDaemon implements Daemon {
	private ClassPathXmlApplicationContext ctx;
	private AuthServer authServer;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(DaemonContext arg0) throws DaemonInitException, Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		int port = 7911;
		String nodeName = "/authService";
		
		authServer = new AuthServer(ctx, port, nodeName);
		authServer.removeZkNode();
		authServer.startServer();
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		authServer.stopServer();
		authServer.removeZkNode();
	}

}
