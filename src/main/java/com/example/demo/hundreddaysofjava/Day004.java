package com.example.demo.hundreddaysofjava;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

/**
 * Day 4 - Removing items from a List.
 */
@Slf4j
public class Day004 {

	public static void main(String[] args) {

		List<Person> beatles = new ArrayList<>();
		beatles.add(new Person("1", "John Lennon", LocalDate.of(1940, 10, 9)));
		beatles.add(new Person("2", "Paul McCartney", LocalDate.of(1942, 6, 18)));
		beatles.add(new Person("3", "George Harrison", LocalDate.of(1943, 2, 25)));
		beatles.add(new Person("4", "Ringo Starr", LocalDate.of(1940, 7, 7)));

		removeItemUsingEquals(beatles);
		
		removeItemUsingAnSpecificFilter(beatles);
		
		log.info("{}", beatles);
		
	}

	private static void removeItemUsingAnSpecificFilter(List<Person> beatles) {
		beatles.removeIf(person -> "George Harrison".equals(person.getName()));
	}

	private static void removeItemUsingEquals(List<Person> beatles) {
		var lennon = new Person("1", "John Lennon", LocalDate.of(1940, 10, 9));
		beatles.remove(lennon);
	}

	@Value
	@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
	@AllArgsConstructor
	static class Person {

		private final String id;
		private final String name;
		private final LocalDate dateOfBirth;

	}

}
