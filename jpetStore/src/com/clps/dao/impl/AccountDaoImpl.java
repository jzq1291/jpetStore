package com.clps.dao.impl;

import org.springframework.stereotype.Repository;

import com.clps.dao.AccountDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Account;

@Repository
public class AccountDaoImpl extends BaseHibernateDAO implements AccountDao {

	@Override
	public void inserAccount(Account account) {
		this.getHibernateTemplate().saveOrUpdate(account);
	}

	@Override
	public Account getAccountByUserId(String username) {
		return (Account) getHibernateTemplate().get(Account.class, username);
	}

}
