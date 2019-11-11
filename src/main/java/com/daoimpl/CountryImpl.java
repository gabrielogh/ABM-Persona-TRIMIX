package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoapi.CountryDao;
import com.entities.Country;


@Repository
@Transactional
public class CountryImpl implements CountryDao{

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Country country) {
		session.getCurrentSession().saveOrUpdate(country);
		return true;
	}

	public List<Country> list() {
		return session.getCurrentSession().createQuery("from countries").list();
	}

	public boolean delete(Country country) {
		try{
			session.getCurrentSession().delete(country);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
	
	
}
