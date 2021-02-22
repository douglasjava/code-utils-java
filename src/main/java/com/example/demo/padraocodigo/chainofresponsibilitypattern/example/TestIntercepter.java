package com.example.demo.padraocodigo.chainofresponsibilitypattern.example;

import java.util.ArrayList;
import java.util.List;

public class TestIntercepter {

	public static void main(String[] args) {

		List<Interceptor> interceptors = new ArrayList<>();
		interceptors.add(new AuthInterceptor());
		interceptors.add(new ChartSetInterceptor());
		interceptors.add(new ProcessInterceptor());

		for (int i = 0; i < interceptors.size(); i++) {
			Interceptor interceptor = interceptors.get(i);

			boolean isNextInvoke = interceptor.execute();

			if (!isNextInvoke) {
				break;
			}

		}

	}

}
