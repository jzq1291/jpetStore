package com.clps.dao;

import com.clps.vo.Category;

/**
 * @author bill
 * @date   2018年1月30日 下午2:47:24
 */
public interface CategoryDao {
	
	
	/**
	 * 通过种类Id获取动物种类
	 * @author  bill
	 * @date    2018年1月30日 下午2:47:27
	 * @param   catid
	 * @return  动物种类
	 */
	public Category getCategoryById(String catid);
}
