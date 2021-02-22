package com.example.demo.padraocodigo.prototypepattern;

public class Prototype implements Cloneable {

	private String name;
	private Person person;

	public Prototype(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Prototype prototype = null;
		prototype = (Prototype) super.clone();
		
		if(this.person != null) {
			Object objectPerson = person.clone();
			prototype.person = (Person) objectPerson;
		}
		
		return super.clone();
	}

}
