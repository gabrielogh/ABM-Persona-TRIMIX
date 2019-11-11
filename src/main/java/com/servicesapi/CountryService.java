package com.servicesapi;

import java.util.List;

import com.entities.Country;

public interface CountryService {
	public boolean saveOrUpdate(Country country);
	public List<Country> list();
	public boolean delete(Country country);
}
