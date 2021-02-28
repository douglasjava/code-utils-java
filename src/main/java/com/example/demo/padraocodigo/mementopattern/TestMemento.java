package com.example.demo.padraocodigo.mementopattern;

public class TestMemento {

	public static void main(String[] args) {

		Notepad notepad = new Notepad();
		Originator origem = new Originator();

		origem.setState("Move you in the direction of your dream");
		notepad.push(origem.createMemento());

		origem.setState("Ways to start your day positively");
		notepad.push(origem.createMemento());

		origem.setState("Love can change the world");
		notepad.push(origem.createMemento());

		origem.setMemento(notepad.back());
		origem.show();

		origem.setMemento(notepad.back());
		origem.show();

		origem.setMemento(notepad.back());
		origem.show();

		System.out.println("----------------------");

		origem.setMemento(notepad.forward());
		origem.show();

		origem.setMemento(notepad.forward());
		origem.show();
		
		origem.setMemento(notepad.forward());
		origem.show();
		
	}

}
