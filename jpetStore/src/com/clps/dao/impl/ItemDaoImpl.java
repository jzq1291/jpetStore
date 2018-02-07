package com.clps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.clps.dao.ItemDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.utils.Pager;
import com.clps.vo.Item;
import com.clps.vo.Product;

@Repository
public class ItemDaoImpl extends BaseHibernateDAO implements ItemDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> queryItemByProduct(Product product, Pager pager) {
		int size=pager.getSize();
		int pageInit=pager.getPage();
		int page=pageInit==0?1:pageInit;
		Session session=getSession();
		String hql = "from Item where productid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0,product.getProductid());
		query.setFirstResult(size*(page-1));
		query.setMaxResults(size);
		List<Item> itemlist= query.list();
		session.close();
		return itemlist;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getTotalPage(Product product) {
		String hql = "select Count(*) from Item where productid = ?";
		List<Long> list=(List<Long>)getHibernateTemplate().find(hql, product.getProductid());
		 if(list!=null&&list.size()>0){
	            return list.get(0).intValue();
	        }
	     return 0;
	}

	@Override
	public Item getItemByitemId(String itemId) {
		return (Item) this.getHibernateTemplate().get(Item.class, itemId);
	}

	@Override
	public int getQty(String itemid) {
		String hql="select qty from Inventory where itemid=?";
		@SuppressWarnings("unchecked")
		List<Integer> list= getHibernateTemplate().find(hql, itemid);
		if(list.size()>0){
			return list.get(0);
		}
		return 0;
	}

}
