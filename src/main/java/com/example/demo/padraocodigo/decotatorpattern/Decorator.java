package com.example.demo.padraocodigo.decotatorpattern;

public abstract class Decorator implements Person {

	protected Person person;

	public Decorator(Person person) {
		this.person = person;
	}
}
