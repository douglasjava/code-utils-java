package com.example.demo.lambda;

import java.util.Arrays;

public class Exemplo8 {

	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}

		System.out.println("sum : " + sum); // 55
		
		sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);

		System.out.println("sum : " + sum); // 55
		
		sum = Arrays.stream(numbers).reduce(0, Integer::sum); // 55

		System.out.println("sum : " + sum); // 55
	}

}
