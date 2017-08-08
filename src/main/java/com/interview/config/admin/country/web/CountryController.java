package com.interview.config.admin.country.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.interview.config.admin.country.domain.Country;
import com.interview.config.admin.country.service.ICountryService;

@Controller
@RequestMapping("user")
public class CountryController {

	@Autowired
	private ICountryService countryService;
	@GetMapping("getCountry/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable("id") Integer id) {
		Country country = countryService.getCountryById(id);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	@GetMapping("listCountry")
	public ResponseEntity<List<Country>> getAllCountry() {
		List<Country> list = countryService.getAllCountry();
		return new ResponseEntity<List<Country>>(list, HttpStatus.OK);
	}
	@PostMapping("addCountry")
	public ResponseEntity<Void> addCountry(@RequestBody Country country, UriComponentsBuilder builder) {
                boolean flag = countryService.addCountry(country);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/country/{id}").buildAndExpand(country.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("updateCuntry")
	public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
		countryService.updateCountry(country);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	@DeleteMapping("deleteCountry/{id}")
	public ResponseEntity<Void> deleteCountry(@PathVariable("id") Integer id) {
		countryService.deleteCountry(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}
