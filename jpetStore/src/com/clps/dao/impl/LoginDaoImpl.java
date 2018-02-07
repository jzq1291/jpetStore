package com.clps.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.clps.dao.LoginDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Bannerdata;
import com.clps.vo.Product;
import com.clps.vo.Profile;
import com.clps.vo.Signon;

@Component
public class LoginDaoImpl extends BaseHibernateDAO implements LoginDao{

	@SuppressWarnings("unchecked")
	@Override
	public Signon findSignonByExample(Signon signon) {
		List<Signon> list = getHibernateTemplate().findByExample(signon);
		
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Profile getProfile(String signonId) {
		String hql="from Profile where userid=?";
		List<Profile> list = getHibernateTemplate().find(hql, signonId);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bannerdata getBannerdata(String favcategory) {
		String hql = "from Bannerdata where favcategory=?";
		List<Bannerdata> list = getHibernateTemplate().find(hql, favcategory);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	
	@Override
	public List<Product> getProductlist(String favcategory) {
		String hql="from Product where category = ?";
		@SuppressWarnings("unchecked")
		List<Product> products=getHibernateTemplate().find(hql, favcategory);
		return products;
	}

}
