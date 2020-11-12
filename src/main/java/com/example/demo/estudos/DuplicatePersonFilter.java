package com.example.demo.estudos;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicatePersonFilter {

	public static void main(String[] args) {
		Person person1 = new Person(1L, "Douglas", "Dias");
		Person person2 = new Person(2L, "João", "Dias");
		Person person3 = new Person(3L, "Débora", "Marques");
		Person person4 = new Person(4L, "Douglas", "Dias");
		
		List<Person> persons = Arrays.asList(person1, person2, person3, person4);
		
		List<Person> duplicatesList = getDuplicates(persons);
		
		duplicatesList.forEach(p -> System.out.println(p.getId()));
		
		
	}
	
	
	public static List<Person> getDuplicates(final List<Person> persons) {
		return getDuplicatesMap(persons).values()
				.stream()
				.filter(duplicates -> duplicates.size() > 1)
				.flatMap(Collection::stream)
			    .collect(Collectors.toList());
	}
	
	
	private static Map<String, List<Person>> getDuplicatesMap(List<Person> persons){
		return persons.stream().collect(groupingBy(Person::uniqueAttributes));
	}

}
