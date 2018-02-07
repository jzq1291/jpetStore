package com.clps.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clps.service.AccountService;
import com.clps.service.OrdersService;
import com.clps.vo.Account;
import com.clps.vo.Orders;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author bill
 * @date   2018年1月30日 下午3:13:41
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")


public class OrdersAction extends ActionSupport implements
ServletRequestAware{
	
	@Autowired
	private OrdersService  ordersService;
	@Autowired
	private AccountService accountService;
	
	@SuppressWarnings("unused")
	private HttpServletRequest request;
	private HttpSession session;
	private Account account;     //账户信息
	private Orders orders;       //订单
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		this.session=request.getSession();
	}
	
	

	
	/**
	 * 提交订单前的查询账户信息显示
	 * @author bill
	 * @date   2018年1月30日 下午3:14:13
	 * @return
	 */
	public String queryAccount(){
		String signonId = (String) session.getAttribute("userid");
		Account account = accountService.getAccountBySignonId(signonId);
		session.setAttribute("account", account);
		return SUCCESS;
	}
	
	

	/**
	 * 下单,获取userId 和系统时间set 到orders
	 * @author bill
	 * @date   2018年1月30日 下午3:14:24
	 * @return
	 */
	public String saveOrder(){
		//获取当前时间
		Date day=new Date();    
		String userid=(String) session.getAttribute("userid");
		orders.setUserid(userid);
		orders.setOrderdate(day);
		ordersService.saveOrder(orders);
		return SUCCESS;
	}
	
}
