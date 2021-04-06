package com.example.demo.lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exemplo12Paralelo {

	public static void main(String[] args) {

		List<Integer> numeros = List.of(1, 2, 3, 4);

		numeros.parallelStream().forEach(System.out::println);

		System.out.println("-------------------//--------------");

		// Sempre repeita a ordem
		numeros.parallelStream().forEachOrdered(System.out::println);

		System.out.println("-------------------//--------------");

		numeros.parallelStream().findAny().ifPresent(System.out::println);

		System.out.println("-------------------//--------------");

		numeros.stream().findAny().ifPresent(System.out::println);

		System.out.println("---------------- unordered----------");

		numeros.parallelStream()
				.unordered() //pode pular qualquer elemento, sem ele, sempre vai pular o primeiro e limitar os 2 primeiros isso pq ta usando o parallelStream
				.skip(1)
				.limit(2)
				.forEach(System.out::println);

		System.out.println("----------- reduce ----------");
		
		numeros.parallelStream()
				.reduce((n1,n2) -> n1 - n2)
				.ifPresent(System.out::println);
		
		
		System.out.println("----------- collect toMap ----------");
		
		Map<Integer, Boolean> collectToMap = numeros.parallelStream().collect(Collectors.toMap(n -> n, n -> n % 2 == 0));
		System.out.println(collectToMap);
		
		System.out.println("----------- collect toConcurrentMap ----------");
		
		Map<Integer, Boolean> collectToConcurrentMap = numeros.parallelStream().collect(Collectors.toConcurrentMap(n -> n, n -> n % 2 == 0));
		System.out.println(collectToConcurrentMap);
		
	}

}
