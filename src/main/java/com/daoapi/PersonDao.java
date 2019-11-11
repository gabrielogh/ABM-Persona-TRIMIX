package com.daoapi;

import java.util.List;

import com.entities.Person;

public interface PersonDao {
	public boolean saveOrUpdatePerson(Person persons);
	public List<Person> list();
	public List<Person> filtredList(String Name, int doctype);
	public boolean delete(Person person);
}
