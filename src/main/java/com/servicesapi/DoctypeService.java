package com.servicesapi;

import java.util.List;

import com.entities.Doctype;

public interface DoctypeService {
	public boolean saveOrUpdate(Doctype doctype);
	public List<Doctype> list();
	public boolean delete(Doctype doctype);
}
