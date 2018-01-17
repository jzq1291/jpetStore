package com.clps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clps.service.AccountService;
import com.clps.vo.Account;
import com.clps.vo.Profile;
import com.clps.vo.Signon;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AccountAction extends ActionSupport implements ServletRequestAware{
	@Autowired
	private AccountService accountService;
	private HttpServletRequest request;
	private HttpSession session;
	private Signon signon;
	private Account account;
	private Profile profile;
	private int result;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Signon getSignon() {
		return signon;
	}
	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public String insertAction(){
		accountService.insertAccount(account,signon,profile);
		return SUCCESS;
	}
}
