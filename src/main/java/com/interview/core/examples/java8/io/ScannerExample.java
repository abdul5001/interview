package com.interview.core.examples.java8.io;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(String arg : args) {
			if(sb.indexOf(arg) < 1 ) {
				sb.append(arg+ " ");
			}
		}
		
		System.err.println(sb.toString());
		
		Scanner sc = new Scanner(sb.toString());
		while(sc.hasNext()) {
			if(sc.hasNextInt()) {
				System.out.print(sc.nextInt() + " ");
			} else {
				sc.next();
			}
		}
		sc.close();
		//RUN with Test null Test 1 2 3 test 
		//ANS
		//Test null Test 1 2 3 test 
		//1 2 3 

	}

}
