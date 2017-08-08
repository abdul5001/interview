package com.interview.core.examples.java8.foreach;

import java.util.HashMap;
import java.util.Set;
import java.util.function.BiConsumer;

public class ForEachMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, MapDto> myMap = new HashMap<Integer,MapDto>();
		for(int i=0; i<10; i++) {
			MapDto dto = new MapDto();
			dto.setAge(i);
			dto.setName("Name of " + i);
			myMap.put(i, dto);
			
		}

		//traversing using Iterator
		Set<Integer> it = myMap.keySet();
		for(Integer i : it){
			System.out.println("Iterator Value::"+ myMap.get(i).getName());
		}
		
		//traversing through forEach method of Iterable with anonymous class
		myMap.forEach(new BiConsumer<Integer, MapDto>() {

			public void accept(Integer age, MapDto map) {
				System.out.println("forEach anonymous class Value::"+map.getName());
			}			

		});
				
		//traversing with Consumer interface implementation
		MyConsumerMap action = new MyConsumerMap();
		myMap.forEach(action);
		
	}

}

//Consumer implementation that can be reused
class MyConsumerMap implements BiConsumer<Integer, MapDto>{

	public void accept(Integer key, MapDto t) {
		System.out.println("Consumer impl Value::"+t.getName());
	}

}

//Consumer implementation that can be reused
class MapDto {

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
