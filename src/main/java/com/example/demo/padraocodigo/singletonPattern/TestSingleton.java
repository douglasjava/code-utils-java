package com.example.demo.padraocodigo.singletonPattern;

public class TestSingleton {

	public static void main(String[] args) {

		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		// As duas instância referem-se ao mesmo endereço na mémoria
		System.out.println(s1); // com.example.demo.padraocodigo.singletonPattern.Singleton@372f7a8d

		System.out.println(s2); // com.example.demo.padraocodigo.singletonPattern.Singleton@372f7a8d

	}

}
