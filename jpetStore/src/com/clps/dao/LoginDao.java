package com.clps.dao;

import java.util.List;

import com.clps.vo.Bannerdata;
import com.clps.vo.Product;
import com.clps.vo.Profile;
import com.clps.vo.Signon;

/**
 * @author bill
 * @date   2018年1月30日 下午2:51:23
 */
public interface LoginDao {

	
	/**
	 * 登录时查询用户是否存在
	 * @author bill
	 * @date   2018年1月30日 下午2:51:28
	 * @param  signon  前台传入的用户信息
	 * @return         根据前台传入查询出的用户
	 */
	public Signon findSignonByExample(Signon signon);

	
	/**
	 * 获取用户喜好
	 * @author bill
	 * @date   2018年1月30日 下午2:51:31
	 * @param  signonId   用户Id
	 * @return            喜好
	 */
	public Profile getProfile(String signonId);

	
	/**
	 * 通过用户喜好返回广告信息
	 * @author bill
	 * @date   2018年1月30日 下午2:51:34
	 * @param  favcategory   喜好的动物种类
	 * @return               要显示的内容
	 */
	public Bannerdata getBannerdata(String favcategory);

	
	/**
	 * 通过用户喜好返回要推荐的数据
	 * @author  bill
	 * @date    2018年1月30日 下午2:51:37
	 * @param   favcategory    喜欢的动物
	 * @return                 产品集
	 */
	public List<Product> getProductlist(String favcategory);
}
