package com.interview.core.examples.java8.threadx;

public class DeadLockExample {

	public static void main(String[] args) {
		final String resource1 = "abc";
		final String resource2 = "xyz";
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.err.println("Thread 1 : rs 1");
					try {
						Thread.sleep(100);
					} catch(Exception e) {}
					
					synchronized (resource2) {
						System.err.println("Thread 1 : rs 2");
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.err.println("Thread 2 : rs 1");
					try {
						Thread.sleep(100);
					} catch(Exception e) {}
					
					synchronized (resource1) {
						System.err.println("Thread 2 : rs 2");
					}
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}