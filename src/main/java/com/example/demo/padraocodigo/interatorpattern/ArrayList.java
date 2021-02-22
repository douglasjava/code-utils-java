package com.example.demo.padraocodigo.interatorpattern;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {

	private int initCapacit = 20;
	private int size;
	private T[] elementData;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		this.elementData = (T[]) new Object[this.initCapacit];
		this.size = 0;
	}

	@Override
	public void add(T element) {

		if (this.size < this.elementData.length) {
			this.elementData[this.size] = element;
			this.size++;
		}

	}

	@Override
	public T get(int index) {
		return this.elementData[index];
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<T> iterator() {
		return new Itr<T>();
	}

	private class Itr<T> implements Iterator<T> {

		int cursor;
		int lastRet = -1;

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public T next() {
			int i = cursor;
			if (i >= size) {
				throw new NoSuchElementException();
			}

			if (i >= elementData.length) {
				throw new ConcurrentModificationException();
			}

			cursor = i + 1;
			return (T) elementData[lastRet = i];

		}

	}

}
