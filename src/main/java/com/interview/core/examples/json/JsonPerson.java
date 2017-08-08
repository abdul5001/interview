package com.interview.core.examples.json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JsonPerson {

	private String name;
	private int age;
	private String sex;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
	private Date joinDate;
	
	//this default constructor needed when JSOn --> Java invoked
	public JsonPerson() {
		
	}
	public JsonPerson(String name, int age, String sex, Date joinDate) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.joinDate = joinDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
}
