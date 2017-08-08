package com.interview.core.examples.java8.interfa;

@FunctionalInterface
public interface Interface1 {

	void method1(String str);
	//IF YOU DECLARE BELOW it will compile error, as functional Interface can not have more than one abstract method
	//void method2(String str);
		
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
	
	
	
}
