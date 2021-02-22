package com.example.demo.padraocodigo.chainofresponsibilitypattern.example;

public class ChartSetInterceptor implements Interceptor {

	@Override
	public boolean execute() {
		System.out.println("Set Character");
		return true;
	}

}
