package com.clps.dao;

import com.clps.vo.Account;

/**
 * @author bill
 * @date   2018年1月30日 下午2:37:16
 */
public interface AccountDao {
	
	/**
	 * 用户注册时保存账户信息
	 * @author bill
	 * @date   2018年1月30日 下午2:37:18
	 * @param  account  账户信息
	 */
	public void inserAccount(Account account);
	

	/**
	 * 通过用户名查找账户信息
	 * @author bill
	 * @date   2018年1月30日 下午2:37:22
	 * @param  username  用户名
	 * @return
	 */
	public Account getAccountByUserId(String username);
}
