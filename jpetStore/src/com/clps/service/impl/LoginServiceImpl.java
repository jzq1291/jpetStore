package com.clps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.LoginDao;
import com.clps.service.LoginService;
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

}
