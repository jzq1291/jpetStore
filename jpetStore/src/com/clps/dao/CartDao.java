package com.clps.dao;

import java.util.List;

import com.clps.vo.Cart;


/**
 * @author bill
 * @date   2018年1月30日 下午2:42:26
 */
public interface CartDao {

	
	/**
	 * 添加商品到购物车(或为商品数量加1)
	 * @author bill
	 * @date   2018年1月30日 下午2:42:30
	 * @param  cart 购物车
	 */
//	public void save(Cart cart);
	
	/**
	 * adadada
	 * */
	/**
	 * 从购物车移除
	 * @author bill
	 * @date   2018年1月30日 下午2:42:31
	 * @param  cart  购物车
	 */
	public void delete(Cart cart);
	
	
	/**
	 * 查找购物车
	 * @author  bill
	 * @date    2018年1月30日 下午2:42:39
	 * @param   signonId  用户id
	 * @return  购物车内所有购物车项
	 */
	public List<Cart> query(String signonId);
	
	
	/**
	 * 查找购物车项
	 * @author  bill
	 * @date    2018年1月30日 下午2:42:42
	 * @param   signonId   用户id
	 * @param   itemId     物品Id
	 * @return  单个购物车项
	 */
	public List<Cart> findCartItem(String signonId, String itemId);
	
}
