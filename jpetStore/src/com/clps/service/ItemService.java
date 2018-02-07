package com.clps.service;

import com.clps.utils.Pager;
import com.clps.vo.Item;
import com.clps.vo.Product;

/**
 * @author bill
 * @date   2018年1月30日 下午1:57:35
 */
public interface ItemService {
	
	
	/**
	 * 通过产品查询出所有该产品下的商品
	 * @author bill
	 * @date   2018年1月30日 下午1:57:35
	 * @param  product  产品
	 * @param  pager   pageBean
	 * @return         物品集
	 */
	public Pager queryItemByProduct(Product product,Pager pager);

	/**
	 * getProductById    通过产品编号 查找产品
	 * @author bill
     * @date   2018年1月30日 下午1:57:35
	 * @param productid  产品编号
	 * @return           产品
	 */
	public Product getProductid(String productid);

	/**
	 * 通过物品编号(item.itemId)查找product
	 * @author bill
	 * @date   2018年1月30日 下午1:57:35
	 * @param itemId      物品编号
	 * @return            商品
	 */
	public Product getProuctByItemId(String itemId);

	/**
	 * 通过物品编号(item.itemId)查找物品
	 * @author bill
	 * @date   2018年1月30日 下午1:57:35
	 * @param itemId   物品编号
	 * @return         物品
	 */
	public Item getItemByItemId(String itemId);

	/**
	 * 获取库存
	 * @author bill
	 * @date   2018年1月30日 下午1:57:35
	 * @param itemid   物品编号
	 * @return         库存
	 */
	public int getQty(String itemid);
}
