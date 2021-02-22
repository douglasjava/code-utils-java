package com.example.demo.padraocodigo.strategyPattern;

public class TestStrategy {

	public static void main(String[] args) {

		Context context = new Context(new Addition());

		double result = context.doCalculete(9, 2);

		System.out.println(String.format("O resultado da operação de %d + %d é %10s", 9, 2, result));

		context = new Context(new Subtraction());

		result = context.doCalculete(6, 2);

		System.out.println(String.format("O resultado da operação de %d - %d é %10s", 6, 2, result));

	}

}
