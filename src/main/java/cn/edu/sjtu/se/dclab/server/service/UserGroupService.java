package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.UserGroup;

/**
 *2015年4月2日 下午4:25:58
 *@author changyi yuan
 */
public interface UserGroupService {

	public void create(UserGroup userGroup);

	public void createGroups(Collection<UserGroup> groups);

}
