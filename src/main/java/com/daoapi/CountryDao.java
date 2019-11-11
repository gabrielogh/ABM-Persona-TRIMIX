package com.daoapi;

import java.util.List;

import com.entities.Country;

public interface CountryDao {
	public boolean saveOrUpdate(Country countries);
	public List<Country> list();
	public boolean delete(Country country);
}
