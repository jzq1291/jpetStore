package com.clps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clps.dao.AccountDao;
import com.clps.dao.ProfileDao;
import com.clps.dao.SignonDao;
import com.clps.service.AccountService;
import com.clps.vo.Account;
import com.clps.vo.Profile;
import com.clps.vo.Signon;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountdao;
	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private SignonDao signonDao;

	@Override
	@Transactional
	public void insertAccount(Account account,Signon signon,Profile profile) {
		String userid=signon.getUsername();
		account.setUserid(userid);
		profile.setUserid(userid);
		signonDao.insertSignonDao(signon);
		accountdao.inserAccount(account);
		profileDao.insertProfile(profile);
	}
}
