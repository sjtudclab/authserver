package cn.edu.sjtu.se.dclab.authserver.thrift;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.sjtu.se.dclab.authserver.utils.Constants;

public class AuthDaemon implements Daemon {
	private Logger logger = LoggerFactory.getLogger(AuthDaemon.class);
	private ClassPathXmlApplicationContext ctx;
	private AuthServer authServer;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(DaemonContext arg0) throws DaemonInitException, Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        String confDir = System.getenv("CONF_DIR");
		Constants.init(confDir + "/application.properties");
		logger.info("daemon inited");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		logger.info("daemon start");
		try {
			int port = Constants.THRIFT_SERVER_PORT;
			String nodeName = Constants.THRIFT_SERVER_ROOTNAME;
			
			authServer = new AuthServer(ctx);
			authServer.removeZkNode();
			authServer.startServer();
			logger.info("daemon started");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		try {
			authServer.stopServer();
			authServer.removeZkNode();
		} catch (Exception ex){
			logger.info(ex.getMessage());
		}
	}

}
