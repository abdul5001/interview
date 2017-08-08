package com.interview.config.admin.country.dao;

import java.util.List;

import com.interview.config.admin.country.domain.Country;

public interface ICountryDao {

	List<Country> getAllCountry();
    Country getCountryById(long id);
    void addCountry(Country country);
    void updateCountry(Country country);
    void deleteCountry(long id);
    boolean countryExists(String code);

}
