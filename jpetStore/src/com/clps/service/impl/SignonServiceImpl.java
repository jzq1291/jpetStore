package com.clps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.SignonDao;
import com.clps.service.SignonService;
import com.clps.vo.Signon;

@Service
public class SignonServiceImpl implements SignonService {

	@Autowired
	private SignonDao signonDao;
	@Override
	public void insertSignon(Signon signon) {
		signonDao.insertSignonDao(signon);
	}

}
