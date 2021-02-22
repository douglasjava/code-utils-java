package com.example.demo.padraocodigo.factoryPattern;

public class Factory {

	public static Product create(int type) {

		Product product = null;

		if (type == 0) {
			product = new Computer();
		} else if (type == 1) {
			product = new Mouse();
		}

		return product;

	}

}
