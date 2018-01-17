package com.clps.utils;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class BaseHibernateDAO extends HibernateDaoSupport{

	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

}
