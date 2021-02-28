package com.example.demo.padraocodigo.proxypattern;

public class TestProxy {

	public static void main(String[] args) {

		Target target = new Target();

		MyHandler myHandler = new MyHandler();
		myHandler.setTarget(target);

		MyProxy proxy = new MyProxy();
		proxy.setMyHandler(myHandler);

		TargetInterface interface1 = (TargetInterface) proxy.getProxy(myHandler);
		interface1.doSomething();

		System.out.println("------------------");

		TargetInterface2 interface2 = (TargetInterface2) proxy.getProxy(myHandler);
		interface2.study();
	}

}
