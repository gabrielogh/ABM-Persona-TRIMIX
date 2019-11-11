package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoapi.DoctypeDao;
import com.entities.Doctype;


@Repository
@Transactional
public class DoctypeImpl implements DoctypeDao{

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Doctype doctype) {
		session.getCurrentSession().saveOrUpdate(doctype);
		return true;
	}

	public List<Doctype> list() {
		return session.getCurrentSession().createQuery("from doctypes").list();
	}

	public boolean delete(Doctype doctype) {
		try{
			session.getCurrentSession().delete(doctype);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
	
	
}
