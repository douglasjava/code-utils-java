package com.example.demo.padraocodigo.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

	private Object target;

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("before");

		method.invoke(this.target, args);

		System.out.println("after");

		return null;
	}

}
