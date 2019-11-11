package com.servicesapi;

import java.util.List;

import com.entities.Person;

public interface PersonService {
	public boolean saveOrUpdatePerson(Person person);
	public List<Person> list();
	public List<Person> filtredList(String Name, int doctype);
	public boolean delete(Person person);
}
