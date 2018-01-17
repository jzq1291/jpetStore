package com.clps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.ProfileDao;
import com.clps.service.ProfileService;
import com.clps.vo.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;

	@Override
	public void insertProfile(Profile profile) {
		profileDao.insertProfile(profile);
	}
}
