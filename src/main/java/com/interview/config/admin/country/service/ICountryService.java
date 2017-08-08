package com.interview.config.admin.country.service;

import java.util.List;

import com.interview.config.admin.country.domain.Country;

public interface ICountryService {

	List<Country> getAllCountry();
	Country getCountryById(int id);
    boolean addCountry(Country country);
    void updateCountry(Country country);
    void deleteCountry(long id);

}
