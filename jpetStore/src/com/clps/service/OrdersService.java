package com.clps.service;

import com.clps.vo.Orders;

/**
 * @author bill
 * @date   2018年1月30日 下午2:16:58
 */
public interface OrdersService {
	
	
	/**
	 * 保存订单
	 * @author bill
	 * @date   2018年1月30日 下午2:16:58
	 * @param orders    订单
	 */
	void saveOrder(Orders orders);
}
