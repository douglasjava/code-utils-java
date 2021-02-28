package com.example.demo.padraocodigo.mementopattern;

import java.util.Stack;

public class Notepad {

	private Stack<Memento> mementos;
	private int index;

	public Notepad() {
		this.mementos = new Stack<>();
	}

	public void push(Memento memento) {
		this.mementos.push(memento);
		this.index++;
	}

	public Memento forward() {
		Memento memento = this.mementos.get(this.index);
		this.index++;
		return memento;
	}

	public Memento back() {
		this.index--;
		Memento memento = mementos.get(this.index);
		return memento;
	}

}
