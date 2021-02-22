package com.example.demo.padraocodigo.strategyPattern;

public class Context {

	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public double doCalculete(double a, double b) {
		return this.strategy.calculate(a, b);
	}

}
