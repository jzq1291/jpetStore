package com.clps.service;

import com.clps.vo.ShoppingCart;

/**
 * @author bill
 * @date   2018年1月30日 下午2:23:38
 */
public interface ShoppingCartService {
	

	/**
	 * 为购物车中某个物品数量加1
	 * @author bill
	 * @date   2018年1月30日 下午2:24:20
	 * @param  signonId   用户id
	 * @param  itemId     物品Id
	 */
	public void add(String signonId, String itemId);
	
	
	/**
	 * 为购物车中某个物品数量减1
	 * @author bill
	 * @date   2018年1月30日 下午2:24:23
	 * @param  signonId   用户id
	 * @param  itemId     物品Id
	 */
	public void sub(String signonId, String itemId);
	
	
	/**
	 * 为购物车中移除某个物品
	 * @author bill
	 * @date   2018年1月30日 下午2:24:27
	 * @param  signonId   用户id
	 * @param  itemId     物品Id
	 */
	public void remove(String signonId, String itemId);
	
	
	/**
	 * 查询购物车
	 * @author bill
	 * @date   2018年1月30日 下午2:24:36
	 * @param  signonId  用户Id
	 * @return           购物车
	 */
	public ShoppingCart query(String signonId);
	
	
	/**
	 * 用户登录时持久化session中的购物车
	 * @author bill
	 * @date   2018年1月30日 下午2:24:37
	 * @param  myCart     购物车
	 * @param  signonId   用户Id
	 */
	public void persistence(ShoppingCart myCart, String signonId);
	
	
	
	/**
	 * 改变购物车中一件物品的数量
	 * @author bill
	 * @date   2018年1月30日 下午2:24:39
	 * @param  signonId   用户Id
	 * @param  itemId     物品Id
	 * @param  count      改变后的数量
	 */
	public void modify(String signonId, String itemId, int count);
}
