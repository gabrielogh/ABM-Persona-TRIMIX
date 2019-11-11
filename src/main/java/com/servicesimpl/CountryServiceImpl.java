package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.CountryDao;
import com.entities.Country;
import com.servicesapi.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryDao countryDao;
	
	public boolean saveOrUpdate(Country country) {
		return countryDao.saveOrUpdate(country);
	}

	public List<Country> list() {
		return countryDao.list();
	}

	public boolean delete(Country country) {
		return countryDao.delete(country);
	}	
	
}
