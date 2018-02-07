package com.clps.dao;

import com.clps.vo.Orders;

/**
 * @author bill
 * @date   2018年1月30日 下午3:01:54
 */
public interface OrdersDao {
	/**
	 * 保存订单
	 * @author bill
	 * @date   2018年1月30日 下午3:01:57
	 * @param  orders  订单
	 */
	void saveOrders(Orders orders);

}
