package com.clps.dao;

import com.clps.vo.Signon;

public interface LoginDao {
	public Signon findSignonByExample(Signon signon);
}
