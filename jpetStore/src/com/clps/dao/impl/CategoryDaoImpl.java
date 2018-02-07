package com.clps.dao.impl;

import org.springframework.stereotype.Repository;

import com.clps.dao.CategoryDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Category;

@Repository
public class CategoryDaoImpl extends BaseHibernateDAO implements CategoryDao {

	@Override
	public Category getCategoryById(String catid) {
		
		return (Category) getHibernateTemplate().get(Category.class, catid);
	}

}
