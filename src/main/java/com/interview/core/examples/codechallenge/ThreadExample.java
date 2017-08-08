package com.interview.core.examples.codechallenge;

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		
		CounterThread counter = new CounterThread();
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		t1.start();
		t2.start();
		
		Thread.sleep(10000);

	}

	
}
class CounterThread implements Runnable {
	private int counter1 = 1;
	private volatile int counter2 = 1;
	private String message = null;
	
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			System.err.println("Counter Non-Vol : " + counter1);	
			counter1++;
			//System.err.println("Counter     Vol : " + counter2);	
			counter2++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
