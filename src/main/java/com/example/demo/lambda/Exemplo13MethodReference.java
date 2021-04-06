package com.example.demo.lambda;

import java.math.BigDecimal;
import java.util.List;

/**
 * Outra forma de representar uma função lambda
 * @author Marques
 *
 */
public class Exemplo13MethodReference {

	public static void main(String[] args) {

		List<Integer> numeros = List.of(1, 2, 3, 4, 5);
		
		//Metodos static
		numeros.stream().map(n -> multipliquePorDois(n)).forEach(System.out::println);
		
		numeros.stream().map(Exemplo13MethodReference::multipliquePorDois).forEach(System.out::println);
		
		//Construtores
		numeros.stream().map(n -> new BigDecimal(n)).forEach(System.out::println);

		numeros.stream().map(BigDecimal::new).forEach(System.out::println);
		
		
		//Varias instancias
		numeros.stream().parallel().map(n -> n.doubleValue()).forEach(System.out::println);
		
		numeros.stream().map(Integer::doubleValue).forEach(System.out::println);
		
		//unica instancia
		BigDecimal dois = new BigDecimal(2);
		numeros.stream()
				.map(BigDecimal::new)
				.map(b -> dois.multiply(b))
				.forEach(System.out::println);
		
		
		numeros.stream()
				.map(BigDecimal::new)
				.map(dois::multiply)
				.forEach(System.out::println);
	}

	private static Integer multipliquePorDois(Integer i) {
		return i * 2;
	}

}
