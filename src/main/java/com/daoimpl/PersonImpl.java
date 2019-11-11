package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoapi.PersonDao;
import com.entities.Person;


@Repository
@Transactional
public class PersonImpl implements PersonDao{

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdatePerson(Person person) {
		session.getCurrentSession().saveOrUpdate(person);
		return true;
	}

	public List<Person> list() {
		return session.getCurrentSession().createQuery("from Person").list();
	}
	
	public List<Person> filtredList(String Name, int doctype){
		return session.getCurrentSession().createQuery("from Person where name like '%:name%' or doctype = (from Doctype where id = :doctype)").setParameter("name", Name).setParameter("doctype", doctype).list();
	}

	public boolean delete(Person person) {
		try{
			session.getCurrentSession().delete(person);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
	
	
}
