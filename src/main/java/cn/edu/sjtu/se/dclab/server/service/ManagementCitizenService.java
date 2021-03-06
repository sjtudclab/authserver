package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.ManagementCitizen;
import cn.edu.sjtu.se.dclab.server.transfer.ManagementCitizenTransfer;

/**
 *2015年3月30日 下午3:07:54
 *@author changyi yuan
 */
public interface ManagementCitizenService {
	public Collection<ManagementCitizenTransfer> findAll(String type);

	public ManagementCitizenTransfer findById(long id);

	public ManagementCitizen findByUserId(long userId);

	public void update(ManagementCitizen citizen);

	public Collection<ManagementCitizenTransfer> findBlockLeaders();
}
