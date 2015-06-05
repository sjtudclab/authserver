package cn.edu.sjtu.se.dclab.authserver.thrift;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.thrift.TException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.authserver.thrift.Auth;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.service.UserService;
import cn.edu.sjtu.se.dclab.server.service.ValidationService;
import cn.edu.sjtu.se.dclab.server.transfer.UserTransfer;

@Service
public class AuthService implements Auth.Iface {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private ValidationService validationService;
	
	public ValidationService getValidationService() {
		return validationService;
	}

	public void setValidationService(ValidationService validationService) {
		this.validationService = validationService;
	}

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
	public boolean hasAuthority(String token, String operation) throws TException {
		try {
			JSONObject jObject = new JSONObject(operation);
			String command = jObject.getString("command");
			JSONObject body = jObject.getJSONObject("body");
			switch (command) {
			case "validation":
				Map<String, Object> map = (toMap(body));
				Map<String, Integer> params = new HashMap<String, Integer>(); 
				@SuppressWarnings("unchecked") Map<String, Object> intermediate =
					    (Map)Collections.checkedMap(params, String.class, Integer.class);
				intermediate.putAll(map);

				String ret = validationService.validateRelation(params);
				return ret.equalsIgnoreCase("true");
			default:
				return false;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public static Map<String, Object> toMap(JSONObject jsonObject) 
    { 
		
        Map<String, Object> result = new HashMap<String, Object>(); 
        Iterator<String> iterator = jsonObject.keys(); 
        
        String key = null; 
        Object value = null; 
        while (iterator.hasNext()) 
        { 
            key = iterator.next(); 
            try {
				value = jsonObject.get(key);
			} catch (JSONException e) {
				e.printStackTrace();
			} 
            result.put(key, value); 
        } 
        return result; 
    } 
}
