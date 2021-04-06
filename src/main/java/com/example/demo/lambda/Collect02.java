package com.example.demo.lambda;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Collect02 {

	public static void main(String[] args) {

		List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);

		toList(numeros);
		toSet(numeros);
		toCollection(numeros);
		joining(numeros);
		averagingInt(numeros);
		summingInt(numeros);
		summarizingInt(numeros);
		count(numeros);
		maxAndMin(numeros);
		groupBY(numeros);
		partitioningBy(numeros);
		toMap(numeros);
	}
	
	private static void toList(List<Integer> numeros) {
		
		//toList
		List<Integer> numerosNovos = numeros.stream()
			   .filter(n -> n %2 == 0)
			   .collect(Collectors.toList());
		
		System.out.println(numeros);
		System.out.println(numerosNovos);
		
	}
	
	private static void toSet(List<Integer> numeros) {
	
		//toSet
		Set<Integer> numerosSet = numeros.stream()
			   .filter(n -> n %2 == 0)
			   .collect(Collectors.toSet());
		
		System.out.println(numeros);
		System.out.println(numerosSet);
		
	}
	
	private static void toCollection(List<Integer> numeros) {
		//toCollection
		Deque<Integer> numerosDeque = numeros.stream()
				   .filter(n -> n %2 == 0)
				   .collect(Collectors.toCollection(
						   	() -> new ArrayDeque<>()
				   ));
			
			System.out.println(numeros);
			System.out.println(numerosDeque);
	}
	
	
	private static void joining(List<Integer> numeros) {
		
		//join
				String join = numeros.stream()
							.map(n -> n.toString())
							.collect(Collectors.joining("; "));
				
				System.out.println(join);
				
	}
	
	//Tirar a média
	private static void averagingInt(List<Integer> numeros) {
		
		
		Double media = numeros.stream()
			   .collect(Collectors.averagingInt(n -> n.intValue()));
		
		System.out.println(media);
		
	}
	
	//Soma
	private static void summingInt(List<Integer> numeros) {
		
		
		Integer media = numeros.stream()
			   .collect(Collectors.summingInt(n -> n.intValue()));
		
		System.out.println(media);
		
	}
	
	
	//summarizingInt
	private static void summarizingInt(List<Integer> numeros) {
		
		
		IntSummaryStatistics status = numeros.stream()
			   .collect(Collectors.summarizingInt(n -> n.intValue()));
		
		System.out.println("IntSummaryStatistics: ");
		System.out.println(status.getAverage());
		System.out.println(status.getCount());
		System.out.println(status.getMax());
		System.out.println(status.getMin());
		System.out.println(status.getSum());
		
	}
	
	//Count
	private static void count(List<Integer> numeros) {
		
		
		Long media = numeros.stream()
				.filter(n -> n % 2 == 0)
			   .collect(Collectors.counting());
		
		System.out.println(media);
		
	}

	//MAX e MIN
	private static void maxAndMin(List<Integer> numeros) {
		
		
		numeros.stream()
			.filter(n -> n % 2 == 0)
		   .collect(Collectors.minBy(Comparator.naturalOrder()))
		   .ifPresent(System.out::println);;
		
		numeros.stream()
				.filter(n -> n % 2 == 0)
			   .collect(Collectors.maxBy(Comparator.naturalOrder()))
			   .ifPresent(System.out::println);;
		

	}
	
	
	//GroupBY
	private static void groupBY(List<Integer> numeros) {
				
		Map<Integer, List<Integer>> map = numeros.stream()
			   .collect(Collectors.groupingBy((n) -> n % 3));
		
		System.out.println(map);
		
	}
	
	
	//partitioningBy
	//Sempre boolean
	private static void partitioningBy(List<Integer> numeros) {
				
		Map<Boolean, List<Integer>> map = numeros.stream()
			   .collect(Collectors.partitioningBy((n) -> n % 3 == 0));
		
		System.out.println(map);
		
	}
	
	private static void toMap(List<Integer> numeros) {
		
		Map<Integer, Integer> map = numeros.stream()
			   .collect(Collectors.toMap(n -> n, n -> n * 2));
		
		System.out.println(map);
		
		Map<Integer, Double> map2 = numeros.stream()
				   .collect(Collectors.toMap(
						   n -> n,
						   n -> Math.pow(n.doubleValue(), 5)
						   ));
			
		System.out.println(map2);
		
	}
	
	
}
