package com.clps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clps.service.InventoryService;
import com.clps.service.ItemService;
import com.clps.service.ShoppingCartService;
import com.clps.utils.StatusUtils;
import com.clps.vo.Item;
import com.clps.vo.ShoppingCart;
import com.clps.vo.Signon;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ShoppingCartAction extends ActionSupport implements
		ServletRequestAware {

	@Autowired
	private ItemService itemService;
	@Autowired
	private ShoppingCartService cartService;
	@Autowired
	private InventoryService inventoryService;
	private HttpServletRequest request;
	private HttpSession session;
	private Item item;                    //物品
	private Signon signon;                //用户
	private ShoppingCart myCart = new ShoppingCart();    //购物车
	private StatusUtils status=new StatusUtils();        //检查用户状态的工具类
	private String result;
	private int res=0;

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ShoppingCart getMyCart() {
		return myCart;
	}

	public void setMyCart(ShoppingCart myCart) {
		this.myCart = myCart;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
		this.session = request.getSession();
	}

	

	
	/**
	 * 添加商品到购物车
	 * @author bill
	 * @date   2018年1月30日 下午3:16:20
	 * @return
	 */
	public String save() {

		
		// 只要登录,session中必然有购物车
		
		if(status.ifLogin()){
			// 如果登录,将购物车项插入到数据库中
			String signonId = (String) session.getAttribute("userid");
			cartService.add(signonId, item.getItemid());
			
			// 查出数据库中的购物车,放入session
			myCart = cartService.query(signonId);
			session.setAttribute("myCart", myCart);
		}else {
			//没有登录,但是session中有购物车
			if(status.ifHaveCart()){
				// 取出session中的购物车
				myCart = (ShoppingCart) session.getAttribute("myCart");
				// 为购物车添加一条记录
				item = itemService.getItemByItemId(item.getItemid());
				myCart.add(item.getItemid(), item);
				session.setAttribute("myCart", myCart);
			}else {
				// 没有登录且session中没有购物车,创建购物车在session中
				item = itemService.getItemByItemId(item.getItemid());
				myCart.add(item.getItemid(), item);
				session.setAttribute("myCart", myCart);
			}
		}

		return SUCCESS;
	}

	
	/**
	 * 查看购物车
	 * @author bill
	 * @date   2018年1月30日 下午3:16:55
	 * @deprecated
	 * @return
	 */
	public String queryShopping() {
		
		// 取出session中的购物车实例化到数据库
		myCart = (ShoppingCart) session.getAttribute("myCart");
		String signonId = (String) session.getAttribute("userid");
		cartService.persistence(myCart,signonId);
		
		myCart = cartService.query(signonId);
		session.setAttribute("myCart", myCart);
		return SUCCESS;
	}
	
	
	

	
	/**
	 * 购物车页面增加某件物品的数量(ajax调用)
	 * @author bill
	 * @date   2018年1月30日 下午3:17:14
	 * @return
	 */
	public String add(){
		String itemId = request.getParameter("itemId");
		int count = Integer.parseInt(request.getParameter("count"));
		//查看库存是否大于当前购物车物品数量
		int inventory = inventoryService.getInventory(itemId);
		if((inventory+1)>count){
			myCart = (ShoppingCart) session.getAttribute("myCart");
			item = itemService.getItemByItemId(itemId);
			myCart.add(itemId, item);
			
			//登录了,持久化到数据库
			if(status.ifLogin()){
				String signonId=(String) session.getAttribute("userid");
				cartService.add(signonId, itemId);
			}
			res=1;
			result="添加了"+item.getItemid()+"一件";
		}else{
			result = "库存不足";
		}
		
		return SUCCESS;
	}
	
	
	

	/**
	 * 购物车页面减少某件物品的数量(ajax调用)
	 * @author bill
	 * @date   2018年1月30日 下午3:17:26
	 * @return
	 */
	public String sub(){
		String itemId = request.getParameter("itemId");
		myCart=(ShoppingCart) session.getAttribute("myCart");
		item = itemService.getItemByItemId(itemId);
		myCart.remove(itemId);
		
		if(status.ifLogin()){
			String signonId=(String) session.getAttribute("userid");
			cartService.sub(signonId, itemId);
		}
		res=1;
		result="删除了"+item.getItemid()+"一件";
		return SUCCESS;
	}
	
	
	
	/**
	 * 移除购物车中的一项
	 * @author bill
	 * @date   2018年1月30日 下午3:17:40
	 * @return
	 */
	public String remove(){
		String itemId = request.getParameter("itemId");
		int count = Integer.parseInt(request.getParameter("count"));
		myCart=(ShoppingCart) session.getAttribute("myCart");
		
		for(int i=0;i<count;i++){
			myCart.remove(itemId);
		}
		
		if(status.ifLogin()){
			String signonId=(String) session.getAttribute("userid");
			cartService.remove(signonId, itemId);
		}
		res=1;
		result="成功移除商品"+itemId;
		
		return SUCCESS;
	}
	
	
	

	/**
	 * 购物车页面用户自由修改某件物品的数量
	 * @author bill
	 * @date   2018年1月30日 下午3:18:02
	 * @return
	 */
	public String modify(){
		String itemId = request.getParameter("itemId");
		int count = Integer.parseInt(request.getParameter("count"));
		int rowCount = Integer.parseInt(request.getParameter("rowCount"));
		myCart=(ShoppingCart) session.getAttribute("myCart");
		item = itemService.getItemByItemId(itemId);
		
		//减少了
		if(rowCount > count){
			for(int i = 0;i<(rowCount-count);i++){
				myCart.remove(itemId);
			}
			if(status.ifLogin()){
				String signonId=(String) session.getAttribute("userid");
				cartService.modify(signonId,itemId,count);
			}
			result="修改"+item.getItemid()+"的数量"+rowCount+"为"+count;
			res=1;
		}
		//增加了
		else{
			//比对库存和变化
			int inventory = inventoryService.getInventory(itemId);
			int change = count-rowCount;
			if((inventory+1) > count){
				for(int i = 0; i<change; i++){
					myCart.add(itemId, item);
				}
				if(status.ifLogin()){
					String signonId=(String) session.getAttribute("userid");
					cartService.modify(signonId,itemId,count);
				}
				result="修改"+item.getItemid()+"的数量"+rowCount+"为"+count;
				res=1;
			}else{
				result = "库存不足";
			}
		}
		return SUCCESS;
	}
}
