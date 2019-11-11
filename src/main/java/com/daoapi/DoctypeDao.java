package com.daoapi;

import java.util.List;

import com.entities.Doctype;

public interface DoctypeDao {
	public boolean saveOrUpdate(Doctype doctypes);
	public List<Doctype> list();
	public boolean delete(Doctype doctypes);
}
