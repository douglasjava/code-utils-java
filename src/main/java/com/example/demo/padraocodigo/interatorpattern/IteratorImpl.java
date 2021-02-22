package com.example.demo.padraocodigo.interatorpattern;

import java.util.List;

public class IteratorImpl<T> implements Iterator<T> {

	private int index;
	private List<T> lista;

	public IteratorImpl(List<T> list) {
		this.lista = list;
	}

	@Override
	public boolean hasNext() {
		return this.index < this.lista.size();
	}

	@Override
	public T next() {
		T element = null;
		if (this.index < this.lista.size()) {
			element = this.lista.get(index);
			this.index++;
		}

		return element;
	}

}
