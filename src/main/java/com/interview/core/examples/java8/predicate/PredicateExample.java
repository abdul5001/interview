package com.interview.core.examples.java8.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PredicateExample {

	public static void main(String[] args) {
		Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
		Employee e2 = new Employee(2,13,"F","Martina","Hengis");
		Employee e3 = new Employee(3,43,"M","Ricky","Martin");
		Employee e4 = new Employee(4,26,"M","Jon","Lowman");
		Employee e5 = new Employee(5,19,"F","Cristine","Maria");
		Employee e6 = new Employee(6,15,"M","David","Feezor");
		Employee e7 = new Employee(7,68,"F","Melissa","Roy");
		Employee e8 = new Employee(8,79,"M","Alex","Gussin");
		Employee e9 = new Employee(9,15,"F","Neetu","Singh");
		Employee e10 = new Employee(10,45,"M","Naveen","Jain");
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
		System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultMale()));
		System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultFemale()));
		System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(35)));
		//Employees other than above collection of "isAgeMoreThan(35)" can be get using negate()
		System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(35).negate()));//not matching list
	}

}

class Employee {
	public Employee(Integer id, Integer age, String gender, String fName, String lName){
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.firstName = fName;
		this.lastName = lName;
	} 
	private Integer id;
	private Integer age;
	private String gender;
	private String firstName;
	private String lastName;

	@Override
	public String toString() {
		return this.id.toString()+" - "+this.age.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
