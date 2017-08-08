package com.interview.core.examples.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonMain {

	public static void main(String[] args) {
		
		JsonPerson p1 = new JsonPerson("Abdullah Shahul Hameed", 41, "M", new Date());
		JsonPerson p2 = new JsonPerson("Yasmin", 36, "F", new Date());
		JsonPerson p3 = new JsonPerson("Mohamed Arshad", 12, "M", new Date());
		JsonPerson p4 = new JsonPerson("Mohamed Hashim", 9, "M", new Date());
		
		List<JsonPerson> list = new ArrayList<JsonPerson>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		String p1Json = java2json(p1);
		System.err.println(p1Json);
		
		String allJson = java2json(list);
		System.err.println(java2json(allJson));
		
		//////////////////////////
		JsonPerson x1 = json2java(p1Json, JsonPerson.class);
		System.err.println(x1.getJoinDate());
	}
	
	public static String java2json(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonStr = mapper.writeValueAsString(obj);
			return jsonStr;
		} catch (JsonGenerationException e) {
		
		} catch (JsonMappingException e) {
			
		} catch (IOException e) {
			
		}
		return "";
	}
	
	public static <T> T json2java(String json, Class<T> cls) {
		ObjectMapper mapper = new ObjectMapper();
		T result = null;
		try {
			result =  mapper.readValue(json, cls);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
