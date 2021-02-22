package com.example.demo.padraocodigo.decotatorpattern;

public class ManagerDecorator extends Decorator {

	public ManagerDecorator(Person person) {
		super(person);
	}

	@Override
	public void show() {
		this.person.show();
		System.out.println("I'm still a manager.");
	}

}
