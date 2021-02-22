package com.example.demo.padraocodigo.bridgepattern;

public class Man extends Person {

	public Man(String name) {
		super(name);
	}

	@Override
	public void dress() {
		System.out.println(super.name + " wear " + super.cloth.getName());
	}

}
