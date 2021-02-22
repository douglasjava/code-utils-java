package com.example.demo.padraocodigo.builderpattern;

public class Director {

	public static Car constructor(Builder builder) {

		builder.buildHead();
		builder.buildBody();
		builder.buildWheel();

		return builder.builPart();

	}

}
