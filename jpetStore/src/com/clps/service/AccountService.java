package com.clps.service;

import com.clps.vo.Account;
import com.clps.vo.Profile;
import com.clps.vo.Signon;

public interface AccountService {
	public void insertAccount(Account account, Signon signon, Profile profile);
}
