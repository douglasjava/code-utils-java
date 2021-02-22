package com.example.demo.padraocodigo.singletonPattern;

/***
 * 
 * <b>SINGLETON PATTERN</b>
 * <p>
 * 
 * Esse padrão garante apenas a existência de apenas uma instancia de uma
 * classe, mantendo um ponto globla de acesso ao objeto.
 * 
 * @author Marques
 *
 */
public class Singleton {

	private static Singleton instance;

	public Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
