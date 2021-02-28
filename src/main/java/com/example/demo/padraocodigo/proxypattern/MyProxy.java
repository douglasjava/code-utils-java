package com.example.demo.padraocodigo.proxypattern;

import java.lang.reflect.Proxy;

public class MyProxy {

	private MyHandler myHandler;

	public void setMyHandler(MyHandler myHandler) {
		this.myHandler = myHandler;
	}

	/**
	 * A ajuda do agente retorna todas as interfaces possíveis
	 * 
	 * @param target
	 * @return
	 */
	public Object getProxy(Object target) {
		return Proxy.newProxyInstance(MyProxy.class.getClassLoader(), target.getClass().getInterfaces(),
				this.myHandler);
	}

}
