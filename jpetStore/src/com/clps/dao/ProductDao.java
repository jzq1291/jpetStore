package com.clps.dao;

import java.util.List;

import com.clps.utils.Pager;
import com.clps.vo.Category;
import com.clps.vo.Product;

/**
 * @author bill
 * @date   2018年1月30日 下午3:02:52
 */
public interface ProductDao {
	
	/**
	 * 通过种类(category)查询出所有产品(Product)
	 * @author bill
	 * @date   2018年1月30日 下午3:02:56
	 * @param  category   商品种类
	 * @param  pager
	 * @return            商品集
	 */
	public List<Product> queryProductByCategory(Category category,Pager pager);

	
	/**
	 * 获取总页数
	 * @author bill
	 * @date   2018年1月30日 下午3:02:59
	 * @param  category    商品种类
	 * @return             总页数
	 */
	public int getTotalPage(Category category);

	
	/**
	 * 获取product
	 * @author  bill
	 * @date    2018年1月30日 下午3:03:02
	 * @param   proId  商品编号
	 * @return         商品
	 */
	public Product getProductById(String proId);
}
