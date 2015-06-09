package authserver;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import cn.edu.sjtu.se.dclab.authserver.thrift.AuthServer;
import cn.edu.sjtu.se.dclab.authserver.utils.Constants;

public class AuthServerTest {

	@Test
	public void testRun() throws IOException {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Resource resource = ctx.getResource("classpath:application.properties");

		Constants.init(resource.getFile().getAbsolutePath());


		AuthServer authServer = new AuthServer(ctx);
		try {
			authServer.removeZkNode();
		} catch (RuntimeException ex) {
			// Normal case
			ex.printStackTrace();
		}
		authServer.startServer();

	}
}
