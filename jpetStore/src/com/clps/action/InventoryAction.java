package com.clps.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clps.service.InventoryService;
import com.clps.vo.Item;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author bill
 * @date   2018年1月30日 下午3:09:49
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class InventoryAction extends ActionSupport {

	@Autowired
	private InventoryService inventoryService;
	private Item item = new Item();  //物品
	private int inventory;           //库存

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	
	/**
	 * 当前商品的库存
	 * @author bill
	 * @date   2018年1月30日 下午3:10:28
	 * @return
	 */
	public String checkInventory() {
		inventory = inventoryService.getInventory(item.getItemid());
		return SUCCESS;
	}
}
