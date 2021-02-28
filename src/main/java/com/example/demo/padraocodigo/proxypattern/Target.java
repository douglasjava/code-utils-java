package com.example.demo.padraocodigo.proxypattern;

public class Target implements TargetInterface, TargetInterface2 {

	@Override
	public void study() {
		System.out.println("Agency for studying abroad");

	}

	@Override
	public void doSomething() {
		System.out.println("Agency registration company");

	}

}
