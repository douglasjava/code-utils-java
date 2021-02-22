package com.example.demo.padraocodigo.builderpattern;

public class TestBuilder {

	public static void main(String[] args) {

		Car car = Director.constructor(new ConcreteBuilder());

		System.out.println(car.getHead());
		System.out.println(car.getBody());
		System.out.println(car.getWheel());

	}

}
