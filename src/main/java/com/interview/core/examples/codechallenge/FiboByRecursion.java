package com.interview.core.examples.codechallenge;

public class FiboByRecursion {

	public static void main(String[] args) {
		for(int i =0; i< 100; i++) {
			System.err.println(i + " = " + fibo(i));
		}

	}
	
	//number 93, may throw overflow error
	public static int fibo(int n) {
		if(n <= 1) {
			return n;
		} else {
			return fibo(n-1) + fibo(n-2);
		}
	}

}
