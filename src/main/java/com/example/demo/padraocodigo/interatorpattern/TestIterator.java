package com.example.demo.padraocodigo.interatorpattern;

public class TestIterator {

	public static void main(String[] args) {

		List<String> lista = new ArrayList<>();

		lista.add("Berkeley University");
		lista.add("Market Street");
		lista.add("Polo Alto");
		lista.add("Polo Alto");
		lista.add("Cuptino");

		Iterator<String> iterator = lista.iterator();
		while (iterator.hasNext()) {
			String valor = iterator.next();
			System.out.println(valor);
		}

	}

}
