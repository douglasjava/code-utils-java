package com.example.demo.lambda;

import java.util.stream.IntStream;

public class Exemplo11 {

	public static void main(String[] args) {
		
		IntStream.range(0, 5)
				.filter(n -> n % 2 == 0)
				.forEach(System.out::println);
		
		
	}
	
}
