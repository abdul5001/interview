package com.interview.core.examples.java8.others;

public class RuntimeExample {

	public static void main(String[] args) {
		System.err.println(Runtime.getRuntime().freeMemory());
		System.err.println(Runtime.getRuntime().totalMemory());
		System.err.println(Runtime.getRuntime().maxMemory());
	}

}
