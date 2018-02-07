package com.clps.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.clps.vo.ShoppingCart;

/**
 * 查看系统用户状态的工具类
 * @author bill
 * @date   2018年1月30日 下午3:19:44
 */
public class StatusUtils{
	
	

	/**
	 * session中是否存在购物车
	 * @author bill
	 * @date   2018年1月30日 下午3:19:57
	 * @return
	 */
	public boolean ifHaveCart(){
	    HttpSession session = ServletActionContext.getRequest().getSession();
		ShoppingCart mySessionCart = (ShoppingCart) session.getAttribute("myCart");
		return mySessionCart!=null;
	}


	/**
	 * 是否已经登录
	 * @author bill
	 * @date   2018年1月30日 下午3:20:10
	 * @return
	 */
	public boolean ifLogin(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String userid = (String)session.getAttribute("userid");
		return userid != null;
	}

}
