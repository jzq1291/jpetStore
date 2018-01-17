package com.clps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.ProductDao;
import com.clps.service.ProductService;
import com.clps.vo.Category;
import com.clps.vo.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> queryProductByCategory(Category category) {
		return productDao.queryProductByCategory(category);
	}

}
