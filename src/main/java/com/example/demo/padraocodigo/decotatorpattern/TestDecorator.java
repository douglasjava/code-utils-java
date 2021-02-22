package com.example.demo.padraocodigo.decotatorpattern;

public class TestDecorator {

	public static void main(String[] args) {

		Person personMan = new Man();
		personMan.show();

		System.out.println("----------------------------");

		personMan = new ManagerDecorator(personMan);
		personMan.show();

		System.out.println("----------------------------");

		personMan = new ActorDecorator(personMan);
		personMan.show();

	}

}
