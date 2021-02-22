package com.example.demo.padraocodigo.flyweightpattern;

public class TestCache {

	public static void main(String[] args) {
		
		Cache.put("1", 1000);
		
		Cache.put("1", 1000);
		
		Cache.put("name", "Douglas");
		
		Cache.put("person", new Person("Débora"));
		
		System.out.println(Cache.get("1"));
		
		System.out.println(Cache.get("name"));
		
		Person person = (Person) Cache.get("person");
		System.out.println(person.getName());
		
		CacheLista.put("1", "Douglas");
		CacheLista.put("1", "Débora");
		
		System.out.println(CacheLista.get("1"));
		
	}

	
}
