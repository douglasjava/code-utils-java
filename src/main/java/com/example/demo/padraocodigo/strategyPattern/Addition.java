package com.example.demo.padraocodigo.strategyPattern;

public class Addition extends Strategy {

	@Override
	public double calculate(double a, double b) {
		return a + b;

	}

}
