package com.clps.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.service.ItemService;
import com.clps.utils.Pager;
import com.clps.vo.Item;
import com.clps.vo.Product;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class ItemAction extends ActionSupport {

	@Autowired
	private ItemService itemService;

	private Pager pager = new Pager();
	private Product product;   //产品
	private Item item;         //物品
	private int qty;           //库存

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	/**
	 * 通过产品ID(product.productid)找个此类商品下的所有物品
	 * @author bill
	 * @date   2018年1月30日 下午3:11:14
	 * @return
	 */
	public String queryItemByProduct() {
		// getProductorById,找到一个Product
		product = itemService.getProductid(product.getProductid());
		pager = itemService.queryItemByProduct(product, pager);
		return SUCCESS;
	}

	
	
	/**
	 *  通过物品Id(item.itemId) 查看物品详情
	 * @author bill
	 * @date   2018年1月30日 下午3:11:27
	 * @return
	 */
	public String getItemDetail() {
		product = itemService.getProuctByItemId(item.getItemid());
		item = itemService.getItemByItemId(item.getItemid());
		qty = itemService.getQty(item.getItemid());
		return SUCCESS;
	}

}
