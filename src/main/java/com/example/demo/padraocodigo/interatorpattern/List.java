package com.example.demo.padraocodigo.interatorpattern;

public interface List<T> {

	void add(T element);

	T get(int index);

	int size();

	Iterator<T> iterator();

}
