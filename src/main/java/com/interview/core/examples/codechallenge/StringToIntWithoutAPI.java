package com.interview.core.examples.codechallenge;

public class StringToIntWithoutAPI {

	public static void main(String[] args) {
		convet2int("104");
		convet2intJDK8("104");

	}
	
	public static int convet2int(String inStr) {
		int result = 0;
					
		int len = inStr.length();
		for(int i  = 0 ; i < len ; i++) {
			char c = inStr.charAt(i);
			int aDigit = (int)c - 48;
			result*=10;
			result+=aDigit;
		}
				
		System.err.println(result);
		return result;
	}
	
	public static int convet2intJDK8(String inStr) {
		int result = inStr.chars().reduce(0, (sum, digit) -> sum * 10 + (digit -48));
				
		System.err.println(result);
		return result;
	}

}
