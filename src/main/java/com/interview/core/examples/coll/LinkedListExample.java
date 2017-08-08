package com.interview.core.examples.coll;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

	public String x = "called in finalize method";
	public static void main(String[] args) {
		
		LinkedList<String> al=new LinkedList<String>();
		al.add("Abdul");
		al.add("Hashim");
		al.add("Abdul");
		al.add("Arshad");

		Iterator<String> itr=al.iterator();
		while(itr.hasNext()) {
			System.err.println(itr.next());
		}
		
		LinkedListExample ex = new LinkedListExample();
		ex.print();
	}
	
	public void print() {
		System.err.println(x);
	}
	//@Override
	protected void finalize() throws Throwable {
		System.err.println("about to finalize");
		super.finalize();
	}

}
