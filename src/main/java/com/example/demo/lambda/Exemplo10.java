package com.example.demo.lambda;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo10 {

	public static void main(String[] args) {

		// Create a String with no repeated keys
		Stream<String[]> str = Stream
				.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "G", "Geeks" } });

		// Convert the String to Map
		// using toMap() method
		Map<String, String> map = str.collect(Collectors.toMap(p -> p[0], p -> p[1]));

		// Print the returned Map
		System.out.println("Map:" + map);
	}

}
