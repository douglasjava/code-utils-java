package com.example.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * {@code} peek serve para informar a linha que está passando na stream
 * @author Marques
 *
 */
public class TesteMain {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		list.stream()
			.peek(n -> System.out.println(n))
			.filter(n -> n % 2 ==0)
			.peek(n -> System.out.println(n + " - passou filter"))
			.forEach(System.out::println);
		
		Stream.of("one", "two", "three", "four")
	              .filter(e -> e.length() > 3)
	              .peek(e -> System.out.println("Filtered value: " + e))
	              .map(String::toUpperCase)
	              .peek(e -> System.out.println("Mapped value: " + e))
	              .collect(Collectors.toList());

	}

}
