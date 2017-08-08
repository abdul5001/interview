package com.interview.config.admin.country.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.interview.config.admin.country.domain.Country;

@Transactional
@Repository
public class CountryDao implements ICountryDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Country getCountryById(long id) {
		return entityManager.find(Country.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getAllCountry() {
		String hql = "FROM Country as ctry ORDER BY ctry.code";
		return (List<Country>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCountry(Country country) {
		entityManager.persist(country);
	}
	@Override
	public void updateCountry(Country country) {
		Country ctry = getCountryById(country.getId());
		ctry.setName(country.getName());
		ctry.setImportStatus(country.isImportStatus());
		ctry.setExportStatus(country.isExportStatus());
		ctry.setTranshipmentStatus(country.isTranshipmentStatus());
		entityManager.flush();
	}
	
	@Override
	public void deleteCountry(long id) {
		entityManager.remove(getCountryById(id));
	}
	
	@Override
	public boolean countryExists(String code) {
		String hql = "FROM Country as ctry WHERE ctry.code = ? ";
		int count = entityManager.createQuery(hql)
						.setParameter(1, code)
						.getResultList().size();
		return count > 0 ? true : false;
	}

}
