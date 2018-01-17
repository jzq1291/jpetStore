package com.clps.dao;

import com.clps.utils.BaseHibernateDAO;

public class CommonDao<T> extends BaseHibernateDAO {
	public  void inserAccount(T t) {
		this.getHibernateTemplate().save(t);
	}
}
