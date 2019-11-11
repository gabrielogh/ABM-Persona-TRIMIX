package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.DoctypeDao;
import com.entities.Doctype;
import com.servicesapi.DoctypeService;

@Service
public class DoctypeServiceImpl implements DoctypeService{

	@Autowired
	DoctypeDao doctypeDao;
	
	public boolean saveOrUpdate(Doctype doctype) {
		return doctypeDao.saveOrUpdate(doctype);
	}

	public List<Doctype> list() {
		return doctypeDao.list();
	}

	public boolean delete(Doctype doctype) {
		return doctypeDao.delete(doctype);
	}	
	
}
