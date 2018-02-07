package com.clps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.clps.dao.ProductDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.utils.Pager;
import com.clps.vo.Category;
import com.clps.vo.Product;

@Repository
public class ProductDaoImpl extends BaseHibernateDAO implements ProductDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> queryProductByCategory(Category category,Pager pager) {
		int size=pager.getSize();
		int pageInit=pager.getPage();
		int page=pageInit==0?1:pageInit;
		Session session=getSession();
		String hql = "from Product where category = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0,category.getCatid());
		query.setFirstResult(size*(page-1));
		query.setMaxResults(size);
		List<Product> productlist= query.list();
		session.close();
		return productlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalPage(Category category) {
		String hql = "select Count(*) from Product where category = ?";
		List<Long> list=(List<Long>)getHibernateTemplate().find(hql, category.getCatid());
		 if(list!=null&&list.size()>0){
	            return list.get(0).intValue();
	        }
	     return 0;
	}

	@Override
	public Product getProductById(String proId) {
		String hql = "from Product where productid = ?";
		@SuppressWarnings("unchecked")
		List<Product> list=getHibernateTemplate().find(hql, proId);
		if(list.size()>0){
			return list.get(0);
		}else {
			return null;
		}
	}

}
