package com.example.demo.padraocodigo.bridgepattern;

public abstract class Person {

	protected String name;
	protected Clothing cloth;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clothing getCloth() {
		return cloth;
	}

	public void setCloth(Clothing cloth) {
		this.cloth = cloth;
	}

	public abstract void dress();
	
}
