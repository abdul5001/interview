package com.interview.core.examples.java8.others;

public class EqualhashCodeExample {

	public static void main(String[] args) {
		String a = "1";
		String b = a;
		System.err.println(a == b); // true
		System.err.println(a == "1"); // true
		System.err.println(a.equals(b)); //true
		
		String ax = "a";
		String bx = "a";		
		System.err.println(ax == bx); //true
		System.err.println(ax.hashCode() + ", " + bx.hashCode());//91/97
		
		///
		Integer ix = new Integer(10);
		Integer iy = new Integer(10);
		System.err.println(ix == iy);//false		
		System.err.println(ix.hashCode() + ", " + iy.hashCode());//10,10
	
	}
}
