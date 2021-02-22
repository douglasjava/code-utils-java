package com.example.demo.padraocodigo.strategyPattern;

public class Subtraction extends Strategy {

	@Override
	public double calculate(double a, double b) {
		return a - b;
	}

}
