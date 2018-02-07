package com.clps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.OrdersDao;
import com.clps.service.OrdersService;
import com.clps.vo.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public void saveOrder(Orders orders) {
		ordersDao.saveOrders(orders);
	}
	
}
