package com.interview.core.examples.java8.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			myList.add(i);
		}

		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("Iterator Value::"+i);
		}
		
		//traversing through forEach method of Iterable with anonymous class
		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}

		});
					
		//traversing with Consumer interface implementation
		MyConsumerList action = new MyConsumerList();
		myList.forEach(action);
		
	}

}

//Consumer implementation that can be reused
class MyConsumerList implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}

}
