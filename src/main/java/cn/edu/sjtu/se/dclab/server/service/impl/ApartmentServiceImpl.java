package cn.edu.sjtu.se.dclab.server.service.impl;


import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.entity.Citizen;
import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.mapper.ApartmentMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserMapper;
import cn.edu.sjtu.se.dclab.server.service.ApartmentService;
import cn.edu.sjtu.se.dclab.server.transfer.ApartmentTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentMapper apartmentMapper;
    @Autowired
    private UserMapper userMapper;

    public ApartmentMapper getApartmentMapper() {
        return apartmentMapper;
    }

    public void setApartmentMapper(ApartmentMapper apartmentMapper) {
        this.apartmentMapper = apartmentMapper;
    }

    public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
    public Collection<Apartment> findAll() {
    	Collection<Apartment> apartments = apartmentMapper.findAll();

        return apartments;
    }

    @Override
    public Collection<Apartment> findAllByBuildingId(long id) {
        return apartmentMapper.findAllByBuildingId(id);
    }

    @Override
    public Collection<ResidentCitizen> findAllCitizenByApartmentId(long id) {
        return apartmentMapper.findAllCitizenByApartmentId(id);
    }
}
