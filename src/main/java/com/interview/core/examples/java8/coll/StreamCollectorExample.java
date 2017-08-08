package com.interview.core.examples.java8.coll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorExample {

	public static void main(String[] args) {
		
		//1
		String[] strAr = new String[] {"Jupitar", "Neptune","Mars", "Earth"};
		List<String> names = Arrays.asList(strAr);//"Jupitar", "Neptune","Mars", "Earth");
		Map<Integer, List<String>> namelength = 
				names.stream()
				.collect(Collectors.groupingBy(p -> p.length()));
	
		namelength.forEach((l,s) -> System.out.print(l + "=" + s + " "));
		System.out.println();

		//ANS : 4=[Mars] 5=[Earth] 7=[Jupitar, Neptune] 
		
		//2 : Stream.collect() with Collectors.joining() 
		List<String> list = Arrays.asList("Ram","Shyam","Shiv","Mahesh");
		String result=  list.stream().collect(Collectors.joining(", "));
		System.out.println("Joining Result: "+ result);
		//ANS : Joining Result: Ram, Shyam, Shiv, Mahesh

		//3 Stream.collect() with Collectors.averagingInt() 
		List<Integer> list1 = Arrays.asList(1,2,3,4);
        Double result1 = list1.stream().collect(Collectors.averagingInt(v->v*2));
        System.out.println("Average: "+result1);
        //ANS 5
        
        //4 : Stream.collect() with Collectors.counting() 
        List<Integer> list2 = Arrays.asList(1,2,3,4);
        long result2=  list2.stream().collect(Collectors.counting());
        System.out.println("Count: "+ result2);
        //ANS : Count: 4
        
        //5: Stream.collect() with Collectors.toList() 
        String[] strArray = {"AA", "BB", "CC"};
        List<String> list5 = Arrays.stream(strArray).collect(Collectors.toList());
        list5.forEach(s->System.out.println(s));
        //list5.forEach(System.out::println); using double ::
        
        //ANS : print one by one

        //6  Stream.collect() with Collectors.toMap() using double colon operator (::)
        List<Person> list6 = new ArrayList<Person>();
		list6.add(new Person(100, "Mohan"));
		list6.add(new Person(200, "Sohan"));
		list6.add(new Person(300, "Mahesh"));
		Map<Integer, String> map = list6.stream()
				.collect(Collectors.toMap(Person::getId, Person::getName));
		map.forEach((x, y) -> System.out.println("Key: " + x +", value: "+ y));
	}

}
class Person {
	private Integer id;
	private String name;
	public Person(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
} 
