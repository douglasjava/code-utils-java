package com.example.demo.padraocodigo.chainofresponsibilitypattern.example;

public class ProcessInterceptor implements Interceptor {

	@Override
	public boolean execute() {
		System.out.println("Business Preprocessing");
		return true;
	}

}
