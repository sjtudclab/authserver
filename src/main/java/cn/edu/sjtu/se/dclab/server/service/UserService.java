package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;
import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.transfer.UserRoleTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.UserTransfer;

/**
 *2015骞�鏈�9鏃�涓嬪崍9:43:23
 *@author changyi yuan
 */
public interface UserService {
	public UserTransfer getUserByUsername(String username);
	
	public Collection<UserTransfer> getAllUsers();

	public Collection<UserTransfer> getUserByCategory(String category);
	
	public void updateUser(UserTransfer userTransfer);
	
	public void updateUserRole(UserRoleTransfer userRoleTransfer);
	public void updateUserRoles(List<UserRoleTransfer> userRoleTransfers);
	
	public UserTransfer authenticateUser(String username,String password);
	public User getUserByUserId(long id);
	
	public UserTransfer getUserByCardInfo(String cardType, String cardNumber, String citizenType);

	public void updateUser(User user);
}
