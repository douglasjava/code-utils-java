package com.example.demo.padraocodigo.visitorpattern;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {

	private List<Person> persons = new ArrayList<>();
	
	public void attach(Person person) {
		this.persons.add(person);
	}
	
	public void detach(Person person) {
		this.persons.remove(person);
	}
	
	public void display(Visitor visitor) {
		for(Person person : this.persons) {
			person.accept(visitor);
		}
	}
	
}
