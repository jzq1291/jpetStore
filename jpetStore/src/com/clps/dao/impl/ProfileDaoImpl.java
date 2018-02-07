package com.clps.dao.impl;

import org.springframework.stereotype.Repository;

import com.clps.dao.ProfileDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Profile;

@Repository
public class ProfileDaoImpl extends BaseHibernateDAO implements ProfileDao {

	@Override
	public void insertProfile(Profile profile) {
		this.getHibernateTemplate().saveOrUpdate(profile);
	}

	@Override
	public Profile getProfileById(String username) {
		return (Profile) this.getHibernateTemplate().get(Profile.class, username);
	}

}
