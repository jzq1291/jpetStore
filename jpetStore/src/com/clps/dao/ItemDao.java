package com.clps.dao;

import java.util.List;

import com.clps.utils.Pager;
import com.clps.vo.Item;
import com.clps.vo.Product;

/**
 * @author bill
 * @date   2018年1月30日 下午2:48:50
 */
public interface ItemDao {

	
	/**
	 * 通过产品Id(product.productId) 查找出所有该类物品
	 * @author bill
	 * @date   2018年1月30日 下午2:48:52
	 * @param  product   产品
	 * @param  pager
	 * @return           物品集
	 */
	public List<Item> queryItemByProduct(Product product,Pager pager);

	
	/**
	 * 获取总页数 
	 * @author bill
	 * @date   2018年1月30日 下午2:48:56
	 * @param  product   产品
	 * @return           总页数
	 */
	public int getTotalPage(Product product);

	
	/**
	 * 获取Item
	 * @author bill
	 * @date   2018年1月30日 下午2:49:02
	 * @param  itemId 
	 * @return  
	 */
	public Item getItemByitemId(String itemId);

	
	/**
	 * 物品库存 
	 * @author bill
	 * @date   2018年1月30日 下午2:49:04
	 * @param  itemid   物品Id
	 * @return          库存
	 */
	public int getQty(String itemid);
}
