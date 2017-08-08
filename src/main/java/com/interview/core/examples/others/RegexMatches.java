package com.interview.core.examples.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

	public static void main(String[] args) {
		String REGEX = "\\bcat\\b";
		String INPUT = "cat cat cat cattie cat";//matches cat in word boundaries, ie cat in cattie is not selected

		Pattern p = Pattern.compile(REGEX);
	    Matcher m = p.matcher(INPUT);   // get a matcher object
	    int count = 0;

	      while(m.find()) {
	         count++;
	         System.out.println("Match number "+count);
	         System.out.println("start(): "+m.start());
	         System.out.println("end(): "+m.end());
	      }


	}

}
