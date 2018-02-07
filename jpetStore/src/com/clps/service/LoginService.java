package com.clps.service;

import java.util.List;

import com.clps.vo.Bannerdata;
import com.clps.vo.Product;
import com.clps.vo.Profile;
import com.clps.vo.Signon;

/**
 * @author bill
 * @date   2018年1月30日 下午2:13:29
 */
public interface LoginService {
	
	/**
	 * 登录
	 * @author bill
	 * @date   2018年1月30日 下午1:57:35
	 * @param signon  前台传入的用户信息
	 * @return        根据前台查询出的用户信息
	 */
	public Signon findSignonByExample(Signon signon);
	
	/**
	 * 通过用户ID查找用户的喜好
	 * @author bill
	 * @date   2018年1月30日 下午1:57:35
	 * @param signonId    用户Id
	 * @return            用户喜好
	 */
	public Profile getProfile(String signonId);
	
	/**
	 * 通过喜好查找显示广告内容
	 * @author bill
	 * @date   2018年1月30日 下午1:57:35
	 * @param favcategory 用户喜欢的动物
	 * @return            返回的东西信息 
	 */
	public Bannerdata getBannerdata(String favcategory);
	
	/**
	 * 
	 * 查询喜欢动物下的所有product
	 * @author bill
	 * @date   2018年1月30日 下午1:57:35
	 * @param favcategory   用户喜欢的动物
	 * @return              用户喜欢动物类型下的所有产品
	 */
	public List<Product> getProductlist(String favcategory);
}
