package com.example.demo.padraocodigo.mementopattern;

public class Originator {

	private String state;

	public Originator() {
		super();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Memento createMemento() {
		return new Memento(this.state);
	}

	public void setMemento(Memento memento) {
		this.state = memento.getState();
	}

	public void show() {
		System.out.println(this.state);
	}

}
