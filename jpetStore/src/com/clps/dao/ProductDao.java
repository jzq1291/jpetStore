package com.clps.dao;

import java.util.List;

import com.clps.vo.Category;
import com.clps.vo.Product;

public interface ProductDao {
	public List<Product> queryProductByCategory(Category category);
}
