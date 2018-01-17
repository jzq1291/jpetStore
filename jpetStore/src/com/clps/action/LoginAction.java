package com.clps.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clps.service.LoginService;
import com.clps.vo.Signon;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<Signon>,
ServletRequestAware{
	private int result=0;

	public void setResult(int result) {
		this.result = result;
	}
	public int getResult() {
		return result;
	}

	private HttpServletRequest request;
	private HttpSession session;
	private LoginService loginService;
	private Signon signon=new Signon();
	
	@Resource(name="loginServiceImpl")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		this.session=request.getSession();
	}

	@Override
//	获取实体
	public Signon getModel() {
		return signon;
	} 
	
//	登录
	public String login(){
		Signon sig=loginService.findSignonByExample(signon);
		if(sig!=null){
			result=1;
			session.setAttribute("userid",signon.getUsername() );
		}
		return SUCCESS;
	}
	
//	注销
	public String drop(){
		session.removeAttribute("userid");
		return SUCCESS;
	}
}
