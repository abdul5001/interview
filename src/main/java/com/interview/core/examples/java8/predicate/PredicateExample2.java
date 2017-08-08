package com.interview.core.examples.java8.predicate;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateExample2 {

	public static void main(String[] args) {
		Predicate<String> lengther = (s) -> s.length() < 2;
		Predicate<String> equalizer =  Predicate.isEqual("car");
		
		Function<Boolean, String> booleaner = i -> Boolean.toString(i);
		Function<String, Boolean> stringer = s -> Boolean.parseBoolean(s);
		
		System.err.println(stringer.compose(booleaner).apply(true));
	}

}
