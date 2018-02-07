package com.clps.service;

import com.clps.vo.Profile;

/**
 * @author bill
 * @date   2018年1月30日 下午2:22:53
 */
public interface ProfileService {
	/**
	 * 注册时保存用户喜好
	 * @author bill
	 * @date   2018年1月30日 下午2:22:56
	 * @param  profile  喜好
	 */
	public void insertProfile(Profile profile);
}
