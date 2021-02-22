package com.example.demo.padraocodigo.bridgepattern;

public class Clothing {

	protected String name;
	protected Person person;

	public Clothing(String name) {
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

}
