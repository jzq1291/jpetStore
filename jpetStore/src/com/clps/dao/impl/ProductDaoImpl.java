package com.clps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.clps.dao.ProductDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Category;
import com.clps.vo.Product;

@Repository
public class ProductDaoImpl extends BaseHibernateDAO implements ProductDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> queryProductByCategory(Category category) {
		System.out.println(category);
		Session session=getSession();
		String hql = "from Product where category = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0,category.getCatid());
		List<Product> productlist= query.list();
		return productlist;
	}

}
