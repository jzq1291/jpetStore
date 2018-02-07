package com.clps.utils;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;


/**
 * @author bill
 * @date   2018年1月30日 下午3:18:32
 */
@Component
public class BaseHibernateDAO extends HibernateDaoSupport{

	/**
	 * @author bill
	 * @date   2018年1月30日 下午3:18:35
	 * @param  sessionFactory
	 */
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

}
