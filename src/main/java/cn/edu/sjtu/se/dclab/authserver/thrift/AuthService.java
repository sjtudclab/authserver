package cn.edu.sjtu.se.dclab.authserver.thrift;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.authserver.thrift.Auth;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.service.UserService;
import cn.edu.sjtu.se.dclab.server.transfer.UserTransfer;

@Service
public class AuthService implements Auth.Iface {
	
	@Autowired
	private UserService userService; 
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void ping() throws TException {
		// TODO Auto-generated method stub
		System.out.println("ping");
	}

	@Override
	public boolean login(String username, String password) throws AuthFailed,
			TException {
		UserTransfer userTransfer = userService.getUserByUsername(username);
		if (userTransfer == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean hasAuthority(int userid, String operation) throws TException {
		return true;
	}

}
