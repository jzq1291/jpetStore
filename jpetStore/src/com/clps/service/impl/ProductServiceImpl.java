package com.clps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.ProductDao;
import com.clps.service.ProductService;
import com.clps.utils.Pager;
import com.clps.vo.Category;
import com.clps.vo.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Pager queryProductByCategory(Category category,Pager pager) {
		if (pager.getPage()==0) {
			pager.setPage(1);
		}
		pager.setSize(2);
		
		List<Product> list= productDao.queryProductByCategory(category,pager);
		int totalsize=productDao.getTotalPage(category);
		int size=pager.getSize();
		pager.setList(list);
		int totalPage=totalsize % size == 0 ? totalsize / size : totalsize / size + 1;
		pager.setTotalpage(totalPage);
		return pager;
	}

}
