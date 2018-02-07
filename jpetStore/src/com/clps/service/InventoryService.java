package com.clps.service;

/**
 * @author bill
 * @date   2018年1月30日 下午2:12:36
 */
public interface InventoryService {
	
	
	/**
	 * 获取库存
	 * @author bill
	 * @date   2018年1月30日 下午2:16:58
	 * @param itemId  物品编号
	 * @return        物品库存
	 */
	public int getInventory(String itemId);
}
