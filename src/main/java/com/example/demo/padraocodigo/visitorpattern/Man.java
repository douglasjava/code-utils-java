package com.example.demo.padraocodigo.visitorpattern;

public class Man implements Person {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
