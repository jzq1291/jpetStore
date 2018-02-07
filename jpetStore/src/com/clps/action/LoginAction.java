package com.clps.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clps.service.LoginService;
import com.clps.service.ShoppingCartService;
import com.clps.utils.StatusUtils;
import com.clps.vo.Bannerdata;
import com.clps.vo.Product;
import com.clps.vo.Profile;
import com.clps.vo.ShoppingCart;
import com.clps.vo.Signon;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<Signon>,
		ServletRequestAware {

	@Autowired
	private ShoppingCartService cartService;
	private StatusUtils status = new StatusUtils();
	private int result = 0;
	private Profile profile;          //用户喜好
	private Bannerdata bannerdata;    //广告显示的内容
	@SuppressWarnings("unused")
	private HttpServletRequest request; 
	private HttpSession session;       
	private LoginService loginService;
	private Signon signon = new Signon( );  //用户信息

	public Profile getProfile() {
		return profile;
	}

	public Bannerdata getBannerdata() {
		return bannerdata;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getResult() {
		return result;
	}

	@Resource(name = "loginServiceImpl")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	@Override
	// 通过 ModelDriven 获取实体
	public Signon getModel() {
		return signon;
	}

	

	
	/**
	 * 用户登录
	 * @author bill
	 * @date   2018年1月30日 下午3:12:47
	 * @return
	 */
	
	public String login() {
		Signon sig = loginService.findSignonByExample(signon);
		if (sig != null) {
			// 1、标识登录状态
			String signonId = sig.getUsername();
			result = 1;
			session.setAttribute("userid", signonId);

			// 2、登录后持久化session中的购物车
			ShoppingCart myCart = new ShoppingCart();
			if (status.ifHaveCart()) {
				// 取出session中的购物车
				myCart = (ShoppingCart) session.getAttribute("myCart");
				// 将session中的购物车持久化到数据库
				cartService.persistence(myCart, signonId);
			}
			// 将购物车中的数据库重新查出
			myCart = cartService.query(sig.getUsername());
			session.setAttribute("myCart", myCart);

			//3、 登录即从profile中查出用户的喜好
			profile = loginService.getProfile(signonId);
			String favcategory = profile.getFavcategory();
			List<Product> productlist = loginService
					.getProductlist(favcategory);
			session.setAttribute("profile", profile);
			session.setAttribute("productlist", productlist);

		}
		return SUCCESS;
	}

	

	/**
	 * 注销登录
	 * @author bill
	 * @date   2018年1月30日 下午3:13:19
	 * @return
	 */
	public String drop() {
		session.invalidate();
		return SUCCESS;
	}

	

	/**
	 * 植入广告--查询用户是否允许插入广告及用户喜欢动物类型(Ajax自动调用)
	 * @author bill
	 * @date   2018年1月30日 下午3:13:32
	 * @return
	 */
	public String queryBannerdataAction() {
		String signonId = (String) session.getAttribute("userid");
		if (signonId != null) {
			profile = loginService.getProfile(signonId);
			String favcategory = profile.getFavcategory();
			bannerdata = loginService.getBannerdata(favcategory);
		}
		return SUCCESS;
	}
	
}
