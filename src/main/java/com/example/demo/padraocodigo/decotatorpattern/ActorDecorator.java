package com.example.demo.padraocodigo.decotatorpattern;

public class ActorDecorator extends Decorator {

	public ActorDecorator(Person person) {
		super(person);
	}

	@Override
	public void show() {
		this.person.show();
		System.out.println("I'm still an international actor.");

	}

}
