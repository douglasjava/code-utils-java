package com.example.demo.padraocodigo.visitorpattern;

public class Woman implements Person {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
