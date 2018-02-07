package com.clps.dao;

import com.clps.vo.Profile;

/**
 * @author bill
 * @date   2018年1月30日 下午3:04:57
 */
public interface ProfileDao {
	
	/**
	 * 注册时添加用户喜好
	 * @author bill
	 * @date   2018年1月30日 下午3:05:00
	 * @param  profile   用户喜好
	 */
	public void insertProfile(Profile profile);

	
	
	/**
	 * 通过用户Id(signon.username)查找喜好
	 * @author  bill
	 * @date    2018年1月30日 下午3:05:02
	 * @param   username  用户名
	 * @return            喜好
	 */
	public Profile getProfileById(String username);
}
