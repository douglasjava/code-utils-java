package com.example.demo.padraocodigo.facadepattern;

public class TestFacade {

	public static void main(String[] args) {
		Facade facade = new Facade();

		facade.sign();

		System.out.println("-----------------");

		facade.dance();

		System.out.println("-----------------");

		facade.act();

	}

}
