package com.clps.dao;

import com.clps.vo.Signon;

/**
 * @author bill
 * @date   2018年1月30日 下午3:05:45
 */
public interface SignonDao {
	
	/**
	 * 注册保存用户信息(signon)
	 * @author  bill
	 * @date    2018年1月30日 下午3:05:47
	 * @param   signon   用户信息
	 */
	public void insertSignonDao(Signon signon);
	
	
	/**
	 * 通过用户名查询用户信息
	 * @author  bill
	 * @date    2018年1月30日 下午3:05:49
	 * @param   username   用户名
	 * @return             用户信息
	 */
	public Signon getSignonByUsername(String username);
}
