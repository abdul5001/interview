package com.interview.config.admin.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.config.admin.country.dao.ICountryDao;
import com.interview.config.admin.country.domain.Country;

@Service
public class CountryService implements ICountryService {
	@Autowired
	private ICountryDao countryDao;
	@Override
	public Country getCountryById(int articleId) {
		Country obj = countryDao.getCountryById(articleId);
		return obj;
	}	
	@Override
	public List<Country> getAllCountry(){
		return countryDao.getAllCountry();
	}
	@Override
	public synchronized boolean addCountry(Country country){
                if (countryDao.countryExists(country.getCode())) {
    	            return false;
                } else {
    	            countryDao.addCountry(country);
    	            return true;
                }
	}
	@Override
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);
	}
	@Override
	public void deleteCountry(long id) {
		countryDao.deleteCountry(id);
	}

}
