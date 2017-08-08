package com.interview.core.examples.java8.others;

public class Test3 {

	static class Helper {
		private int data = 5;
		public void bump(int inc) {
			inc++;
			data = data + inc;
		}
	}
	
	public static void main(String[] args) {
		Helper h = new Helper();
		int data = 2;
		h.bump(data);
		System.err.println(h.data + " " + data);
		
		//ANS 8 2
	}

}
