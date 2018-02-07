package com.clps.dao.impl;

import org.springframework.stereotype.Repository;

import com.clps.dao.OrdersDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Orders;

@Repository
public class OrdersDaoImpl extends BaseHibernateDAO implements OrdersDao {

	@Override
	public void saveOrders(Orders orders) {
		getHibernateTemplate().save(orders);
	}
}
