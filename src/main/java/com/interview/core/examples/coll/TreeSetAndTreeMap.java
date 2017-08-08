package com.interview.core.examples.coll;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetAndTreeMap {

	public static void main(String[] args) {
		Set<String> x = new TreeSet<String>();
		x.add("y");
		x.add("t");
		x.add("a");
		x.add("s");
		x.add("c");
		
		System.err.println(x);
		
		Map<String, String> tMap = new TreeMap<String, String>();
		tMap.put("y", "a");
		tMap.put("t", "t");
		tMap.put("a", "x");
		tMap.put("s", "s");
		tMap.put("c", "a");
		
		System.err.println(tMap);

	}

}
