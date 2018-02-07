package com.clps.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.clps.dao.CartDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Cart;

@Repository
public class CartDaoImpl extends BaseHibernateDAO implements CartDao {

	@Override
	public void delete(Cart cart) {
		getHibernateTemplate().delete(cart);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> query(String signonId) {
		String hql="from Cart where signonid =? ";
		
		List<Cart> list = getHibernateTemplate().find(hql,signonId);
		return list;
	}

	@Override
	public void save(Cart cart) {
		getHibernateTemplate().saveOrUpdate(cart);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> findCartItem(String signonId, String itemid) {
		Cart cart = new Cart(signonId, itemid, null);
		return getHibernateTemplate().findByExample(cart);
	}
}
