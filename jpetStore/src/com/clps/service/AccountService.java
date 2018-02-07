package com.clps.service;

import com.clps.vo.Account;
import com.clps.vo.Profile;
import com.clps.vo.Signon;

/**
 * @author bill
 * @date   2018年1月30日 下午2:08:50
 */
public interface AccountService {
	
	
	/**
	 * 注册
	 * @param account  账户信息
	 * @param signon   用户信息
	 * @param profile  用户喜好
	 */
	public void insertAccount(Account account, Signon signon, Profile profile);

	/**
	 * 通过用户名查找用户信息
	 * @param username   用户名
	 * @return           用户信息
	 */
	public Signon getSignonBySignonId(String username);

	/**
	 * 通过用户名查找账户信息    
	 * @param username    用户名
	 * @return            账户信息
	 */ 
	public Account getAccountBySignonId(String username);

	/**
	 * 通过用户名查找用户喜好
	 * @param username     用户名
	 * @return             用户喜好
	 */ 
	public Profile getProfileBySignonId(String username);
}
