package com.interview.core.examples.java8.interfa;

public class FunctionalInterfaceEx {

	public static void main(String[] args) {
		Runnable r = new Runnable(){
			@Override
			public void run() {
				System.out.println("My Runnable");
			}};

			r.run();
			
			//USUING LAMBDA
			Runnable r1 = () -> {
				System.out.println("My Runnable using lamda line 1");
				System.out.println("My Runnable using lamda line 2");
			};
			r1.run();
	}

}
