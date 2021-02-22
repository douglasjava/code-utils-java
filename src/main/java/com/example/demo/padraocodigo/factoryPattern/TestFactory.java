package com.example.demo.padraocodigo.factoryPattern;

public class TestFactory {

	public static void main(String[] args) {

		Product product = Factory.create(0);
		product.print();

		product = Factory.create(1);
		product.print();

	}

}
