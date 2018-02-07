package com.clps.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clps.service.AccountService;
import com.clps.vo.Account;
import com.clps.vo.Profile;
import com.clps.vo.Signon;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author bill
 * @date   2018年1月30日 下午3:08:12
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AccountAction extends ActionSupport implements ServletRequestAware{
	@Autowired
	private AccountService accountService;
	private Signon  signon;   //用户信息
	private Account account;  //账户信息
	private Profile profile;  //用户喜好
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

	
	
	/**
	 * 注册
	 * @author bill
	 * @date   2018年1月30日 下午3:08:25
	 * @return
	 */
	public String insertAction(){
		accountService.insertAccount(account,signon,profile);
		return SUCCESS;
	}
	
	
	
	/**
	 * 通过用户ID（signon.username）查询用户信息
	 * @author bill
	 * @date   2018年1月30日 下午3:09:22
	 * @return
	 */
	public String queryInfoByUser(){
		signon = accountService.getSignonBySignonId(signon.getUsername());
		account = accountService.getAccountBySignonId(signon.getUsername());
		profile = accountService.getProfileBySignonId(signon.getUsername());
		
		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		
	}
}
