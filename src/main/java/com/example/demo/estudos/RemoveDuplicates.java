package com.example.demo.estudos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import one.util.streamex.StreamEx;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		List<String> valueStrings = Arrays.asList("teste", "opa", "repetido", "teste", "não", "repetido");
		
		List<String> duplicadoList = valueStrings
			.stream()
			.filter(i -> Collections.frequency(valueStrings, i) > 1)
			.collect(Collectors.toList());
		duplicadoList.forEach(System.out::println);
		
		List<String> repeatingNumbers = StreamEx.of(valueStrings).distinct(2).toList();
		repeatingNumbers.forEach(System.out::println);
	}
	
}
