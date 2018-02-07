package com.clps.service;

import com.clps.utils.Pager;
import com.clps.vo.Category;


/**
 * @author bill
 * @date   2018年1月30日 下午2:20:53
 */
public interface ProductService {
	/**
	 * 
	 * @author bill
	 * @date   2018年1月30日 下午2:20:57
	 * @param category   种类
	 * @param pager      
	 * @return           产品集
	 */
	public Pager queryProductByCategory(Category category,Pager pager);
}
