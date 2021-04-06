package com.example.demo.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Teste1 {

	public static void main(String[] args) {
		List<Integer> lista1 = List.of(1, 2, 3, 4);
		lista1.stream()
			 .filter(e -> e % 2 == 0)
			 .forEach(System.out::println);
		
		
		List<Integer> lista = List.of(1, 2, 3, 4);
		lista.stream()
			 .filter(new Predicate<Integer>() {
				@Override
				public boolean test(Integer e) {
					return e % 2 == 0;
				}
			 })
			 .forEach(new Consumer<Integer>() {
				@Override
				public void accept(Integer t) {
					System.out.println(t);					
				}
			});

	}

}
