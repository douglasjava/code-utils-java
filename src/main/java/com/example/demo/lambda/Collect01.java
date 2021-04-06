package com.example.demo.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collect01 {

	public static void main(String[] args) {
		
		List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);

		// Fornecedor:: () -> new ArrayList<>() -> Objeto para armazenar o resultado
		// final
		// acumulador:: (l, e) -> l.add(e), primeiro elemento é a lista(a propria lista
		// criada acima) e o segundo é o item da lista
		// combinação:: (l1, l2) -> l1.add(l2), para trabalhar em paralelo para agrupar
		// no final em um objeto final, o primeiro atributo é a primeira lista e o
		// segundo é a lista vindo das threads
		Set<Integer> novo = numeros.stream()
				.collect(
						() -> new HashSet<>(), 
						(l, e) -> l.add(e),
						(l1, l2) -> l1.addAll(l2)
				);

		System.out.println(numeros);
		System.out.println(novo);

	}

}
