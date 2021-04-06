package com.example.demo.lambda;

import java.util.List;

/**
 * A lista principal não é alterada
 * 
 * - Operações intermediarias
 * 
 * @author Marques
 *
 */
public class Exemplo2 {

	public static void main(String[] args) {

		List<Integer> numeros = List.of(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);

		System.out.println("--- OPERAÇÃOES INTERMEDIÁRIA ---");

		System.out.println("---------- SKIP -----------");

		numeros.stream().skip(2) // Pula os dois primeros registros
				.forEach(System.out::println);

		System.out.println("----------- LIMIT ----------");

		numeros.stream().limit(2) // quantos elementos quero processar
				.forEach(System.out::println);

		System.out.println("----------- DISTINCT ----------");

		numeros.stream().distinct() // elimina itens repetidos, para List de object certificar que o equals e
									// hashcode foram implementados
				.forEach(System.out::println);

		System.out.println("----------- FILTER ----------");

		numeros.stream().filter(e -> e % 2 == 0).forEach(System.out::println);

		System.out.println("----------- MAP ----------");

		// Transformação de dados
		numeros.stream().map(e -> e * 2).forEach(System.out::println);

	}

}
