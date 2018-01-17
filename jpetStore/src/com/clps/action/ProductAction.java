package com.clps.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clps.service.ProductService;
import com.clps.utils.Pager;
import com.clps.vo.Category;
import com.clps.vo.Product;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@SuppressWarnings("serial")
@Scope("prototype")
public class ProductAction extends ActionSupport implements ServletRequestAware{
	
	@Autowired
	private ProductService productorService;
	private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	private HttpServletRequest request;
	private Pager pager=new Pager();
	List<Product> list=new ArrayList<>();
	
	
		
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public String queryProductByCategory(){
		System.out.println(category);
		list=productorService.queryProductByCategory(category);
		System.out.println(list);
		pager.setList(list);
		request.setAttribute("pager", pager);
		return SUCCESS;
	}
}
