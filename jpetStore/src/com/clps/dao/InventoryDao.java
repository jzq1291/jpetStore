package com.clps.dao;

/**
 * @author bill
 * @date   2018年1月30日 下午2:48:15
 */
public interface InventoryDao {
	
	/**
	 * 获取库存
	 * @author  bill
	 * @date    2018年1月30日 下午2:48:17
	 * @param   itemId  物品Id
	 * @return  库存
	 */
	public int getInventory(String itemId);
}
