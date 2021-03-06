package com.clps.dao.impl;

import org.springframework.stereotype.Repository;

import com.clps.dao.SignonDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Signon;



@Repository
public class SignonDaoImpl extends BaseHibernateDAO implements SignonDao{

	@Override
	public void insertSignonDao(Signon signon) {
		this.getHibernateTemplate().saveOrUpdate(signon);
	}

	@Override
	public Signon getSignonByUsername(String username) {
		return (Signon) this.getHibernateTemplate().get(Signon.class, username);
	}

}
