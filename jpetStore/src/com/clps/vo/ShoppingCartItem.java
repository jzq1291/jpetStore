package com.clps.vo;

/**
 * 购物车项
 * @author bill
 * @date   2018年1月30日 下午3:25:04
 */

public class ShoppingCartItem {
    Object item;    //物品
    int quantity;   //物品数量

    public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ShoppingCartItem(Object anItem) {
        item = anItem;
        quantity = 1;
    }

	
    /**
     * 增加商品时数量加1
     * @author bill
     * @date   2018年1月30日 下午3:25:41
     */
    public void incrementQuantity() {
        quantity++;
    }

    
    
    /**
     * 减少商品时数量减1
     * @author bill
     * @date   2018年1月30日 下午3:26:04
     */
    public void decrementQuantity() {
        quantity--;
    }

    public Object getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}








