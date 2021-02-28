package com.example.demo.padraocodigo.visitorpattern;

public class Success implements Visitor {

	@Override
	public void visit(Man man) {
		System.out.println("When a man succeeds, there is a greta woman behind him.");
	}

	@Override
	public void visit(Woman woman) {
		System.out.println("When a woman succeeds, there is mostly a man behund her.");
	}

}
