package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.PersonDao;
import com.entities.Person;
import com.servicesapi.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDao personDao;
	
	public boolean saveOrUpdatePerson(Person person) {
		return personDao.saveOrUpdatePerson(person);
	}

	public List<Person> list() {
		return personDao.list();
	}
	
	public List<Person> filtredList(String Name, int doctype){
		return personDao.filtredList(Name, doctype);
	}

	public boolean delete(Person person) {
		return personDao.delete(person);
	}	
	
}
