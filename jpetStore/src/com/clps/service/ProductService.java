package com.clps.service;

import java.util.List;

import com.clps.vo.Category;
import com.clps.vo.Product;


public interface ProductService {
	public List<Product> queryProductByCategory(Category category);
}
