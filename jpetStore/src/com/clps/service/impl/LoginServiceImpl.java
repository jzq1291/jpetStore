package com.clps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.LoginDao;
import com.clps.service.LoginService;
import com.clps.vo.Bannerdata;
import com.clps.vo.Product;
import com.clps.vo.Profile;
import com.clps.vo.Signon;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public Signon findSignonByExample(Signon signon) {
		Signon sig=loginDao.findSignonByExample(signon);
		return sig;
	}

	@Override
	public Profile getProfile(String signonId) {
		return loginDao.getProfile(signonId);
	}

	@Override
	public Bannerdata getBannerdata(String favcategory) {
		return loginDao.getBannerdata(favcategory);
	}

	@Override
	public List<Product> getProductlist(String favcategory) {
		return loginDao.getProductlist(favcategory);
	}

}
