package com.clps.service;

import com.clps.vo.Signon;

/**
 * @author bill
 * @date   2018年1月30日 下午2:36:21
 */
public interface SignonService {
	
	/**
	 * 用户注册时存入用户信息
	 * @author bill
	 * @date   2018年1月30日 下午2:36:28
	 * @param  signon  用户信息
	 */
	public void insertSignon(Signon signon);
}
