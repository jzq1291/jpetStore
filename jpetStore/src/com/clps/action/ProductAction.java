package com.clps.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clps.service.ProductService;
import com.clps.utils.Pager;
import com.clps.vo.Category;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author bill
 * @date   2018年1月30日 下午3:14:32
 */
@Controller
@SuppressWarnings("serial")
@Scope("prototype")
public class ProductAction extends ActionSupport{
	
	@Autowired
	private ProductService productorService;
	
	private Pager pager=new Pager();

	private Category category;  // 商品种类
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
		
	

	
	/**
	 * 通过产品种类查询出所有产品
	 * @author bill
	 * @date   2018年1月30日 下午3:15:02
	 * @return
	 */
	public String queryProductByCategory(){
		pager=productorService.queryProductByCategory(category,pager);
		return SUCCESS;
	}
}
