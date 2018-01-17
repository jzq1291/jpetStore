package com.clps.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.clps.dao.LoginDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Signon;

@Component
public class LoginDaoImpl extends BaseHibernateDAO implements LoginDao{

	@Override
	public Signon findSignonByExample(Signon signon) {
		List<Signon> list=getHibernateTemplate().findByExample(signon);
		
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
