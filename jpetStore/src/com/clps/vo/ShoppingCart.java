package com.clps.vo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 购物车
 * @author bill
 * @date   2018年1月30日 下午3:20:41
 */
/**
 * @author bill
 * @date   2018年1月30日 下午3:24:48
 */
/**
 * @author bill
 * @date   2018年1月30日 下午3:24:48
 */
public class ShoppingCart {
	@SuppressWarnings("rawtypes")
	HashMap items = null;      //存购物车项    itemId-ShoppingCartIrtem
	int numberOfItems = 0;     //商品总数量

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	@SuppressWarnings("rawtypes")
	public ShoppingCart() {
		items = new HashMap();
	}

	
	/**
	 * 往购物车中添加一件商品
	 * @author bill
	 * @date   2018年1月30日 下午3:21:22
	 * @param  itemId   物品Id
	 * @param  item     物品
	 */
	@SuppressWarnings("unchecked")
	public synchronized void add(String itemId, Item item) {
		if (items.containsKey(itemId)) {
			ShoppingCartItem scitem = (ShoppingCartItem) items.get(itemId);
			scitem.incrementQuantity();
		} else {
			ShoppingCartItem newItem = new ShoppingCartItem(item);
			items.put(itemId, newItem);
		}

		numberOfItems++;
	}

	
	/**
	 * 往购物车中删除一件商品
	 * @author bill
	 * @date   2018年1月30日 下午3:23:18
	 * @param  itemId   物品编号
	 */
	public synchronized void remove(String itemId) {
		if (items.containsKey(itemId)) {
			ShoppingCartItem scitem = (ShoppingCartItem) items.get(itemId);
			scitem.decrementQuantity();

			if (scitem.getQuantity() <= 0)
				items.remove(itemId);

			numberOfItems--;
		}
	}

	/**
	 * 获取所有购物车项
	 * @author bill
	 * @date   2018年1月30日 下午3:23:51
	 * @return  直接返回values（colection） 而不是Map 
	 */
	@SuppressWarnings("rawtypes")
	public synchronized Collection getItems() {
		return items.values();
	}

	protected void finalize() throws Throwable {
		items.clear();
	}

	public synchronized int getNumberOfItems() {
		return numberOfItems;
	}

	/**
	 * 获取购物车中商品总价
	 * @author bill
	 * @date   2018年1月30日 下午3:24:13
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public synchronized BigDecimal getTotal() {
		BigDecimal amount =new BigDecimal( 0.0);

		for (Iterator i = getItems().iterator(); i.hasNext();) {
			ShoppingCartItem it = (ShoppingCartItem) i.next();
			Item item = (Item) it.getItem();
			BigDecimal quantity = new BigDecimal(it.getQuantity());
			BigDecimal listPrice = item.getListprice();
			amount = amount.add(quantity.multiply(listPrice));
		}
		return amount;
	}

	@SuppressWarnings("unused")
	private double roundOff(double x) {
		long val = Math.round(x * 100); // cents
		return val / 100.0;
	}

	
	/**
	 * 清空购物车
	 * @author bill
	 * @date   2018年1月30日 下午3:24:50
	 */
	public synchronized void clear() {
		items.clear();
		numberOfItems = 0;
	}
}
