package com.example.demo.padraocodigo.chainofresponsibilitypattern.example;

public class AuthInterceptor implements Interceptor {

	@Override
	public boolean execute() {
		System.out.println("Authority Authentication");
		return true;
	}

}
