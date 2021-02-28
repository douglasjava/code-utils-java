package com.example.demo.padraocodigo.visitorpattern;

public class Love implements Visitor {

	@Override
	public void visit(Man man) {
		System.out.println("A man is in love");

	}

	@Override
	public void visit(Woman woman) {
		System.out.println("A woman is in love");

	}

}
