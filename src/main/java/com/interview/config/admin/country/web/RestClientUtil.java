package com.interview.config.admin.country.web;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.interview.config.admin.country.domain.Country;

public class RestClientUtil {

	 public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getCountryByIdDemo();
    	util.getAllCountrysDemo();
    	//util.addCountryDemo();
    	//util.updateCountryDemo();
    	//util.deleteCountryDemo();
    }   
	 
	public void getCountryByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8084/interview/user/getCountry/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Country> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Country.class, 1);
        Country country = responseEntity.getBody();
        System.out.println("Id:"+country.getId()+", Code:"+country.getCode());      
    }
	
    public void getAllCountrysDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8084/interview/user/listCountry";
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	        ResponseEntity<Country[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Country[].class);
	        Country[] countrys = responseEntity.getBody();
	        for(Country country : countrys) {
	        	System.out.println("Id:"+country.getId()+", Code:"+country.getCode());   
	        }
    }
    
    public void addCountryDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8084/interview/user/addCountry";
		Country objCountry = new Country();
		objCountry.setCode("AB");
		objCountry.setName("Abdullah");
        HttpEntity<Country> requestEntity = new HttpEntity<Country>(objCountry, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    
    public void updateCountryDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8084/interview/user/updateCountry";
		Country objCountry = new Country();
		objCountry.setId(1);
		objCountry.setCode("XX");
		objCountry.setName("abdullah updated");
        HttpEntity<Country> requestEntity = new HttpEntity<Country>(objCountry, headers);
        restTemplate.put(url, requestEntity);
    }
    
    public void deleteCountryDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8084/interview/user/deleteCountry/{id}";
        HttpEntity<Country> requestEntity = new HttpEntity<Country>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }   

}
