package com.example.demo.padraocodigo.bridgepattern;

public class Lady extends Person {

	public Lady(String name) {
		super(name);		
	}

	@Override
	public void dress() {
		System.out.println(super.name + " wear " + super.cloth.getName());

	}

}
