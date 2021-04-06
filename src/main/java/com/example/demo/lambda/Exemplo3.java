package com.example.demo.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * - Operações finais
 * 
 * links uteis
 * <p>
 * - https://rinaldo.dev/java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo/ <p>
 * - https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/ <p>
 * - https://www.geeksforgeeks.org/java-8-streams-collectors-joining-method-with-examples/
 * 
 * @author Marques
 *
 */
public class Exemplo3 {

	public static void main(String[] args) {

		List<Integer> numeros = List.of(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);
		
		List<Aluno> alunos = List.of(getAluno(), getAluno1(), getAluno(), getAluno1(), getAluno());
		
		List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
		

		System.out.println("--- OPERAÇÃOES FINAIS ---");

		System.out.println("---------- COUNT -----------");

		long count = numeros.stream().limit(3).map(e -> e * 2).count();

		System.out.println(count);

		count = numeros.stream().filter(e -> e % 2 == 0).count();

		System.out.println(count);
		
		System.out.println("---------- MIN -----------");

		Optional<Integer> min =  numeros.stream()
			   .filter(e -> e % 2 == 0)
			   .min(Comparator.naturalOrder());//Comparador já implementado na classe Integer ->  implements Comparable<Integer>
		
		System.out.println(min.get());
		
		System.out.println("---------- MAX -----------");

		Optional<Integer> max =  numeros.stream()
			   .filter(e -> e % 2 == 0)
			   .max(Comparator.naturalOrder());//Comparador já implementado na classe Integer ->  implements Comparable<Integer>
		
		System.out.println(max.get());
		
		
		System.out.println("---------- COLLECT -----------");

		List<Integer> novaLista = numeros.stream()
			   .filter(e -> e % 2 == 0)
			   .distinct()
			   .collect(Collectors.toList());
			   
		System.out.println(novaLista);
		
	
		
		System.out.println("---------- GROUPBY -----------");

		Map<Boolean, List<Integer>> mapa = numeros.stream()
			   .map(e -> e * 3)
			   .distinct()
			   .collect(Collectors.groupingBy(e -> e % 2 == 0));
			   
		System.out.println(mapa);
		
		
		System.out.println("---------- GROUPBY 1 -----------");

		Map<Integer, List<Integer>> mapa1 = numeros.stream()
			   .collect(Collectors.groupingBy(e -> e % 3));
			   
		System.out.println(mapa1);
		
		
		System.out.println("---------- GROUPBY OBJECT -----------");

		Map<Integer, Long> mapIdade = alunos.stream()
			  .collect(Collectors.groupingBy(Aluno::getIdade, Collectors.counting()));
			   
		System.out.println(mapIdade);
		
		
		System.out.println("---------- GROUPBY OBJECT 1 counting ---------");

		Map<String, Long> counting = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        System.out.println("---------- GROUPBY OBJECT 1 sum ---------");
        
        Map<String, Integer> sum = items.stream()
        		.collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQtde)));

        System.out.println(sum);
        
        /** Só trabalha com String **/
        System.out.println("---------- GROUPBY joining ---------");
        
        String join = numeros.stream()
        	   .map(e -> String.valueOf(e))
        	   .collect(Collectors.joining(";"));

        System.out.println(join);
        
		
        /** Só trabalha com String **/
        System.out.println("---------- GROUPBY joining com prefixo e sufixo ---------");
        
        String join1 = numeros.stream()
        	   .map(e -> String.valueOf(e))
        	   .collect(Collectors.joining(", ", "[", "]")); 

        System.out.println(join1);
		
	}
	
	private static Aluno getAluno() {
		return Aluno.builder()
				.nome(RandomStringUtils.randomAlphabetic(10))
				.idade(RandomUtils.nextInt())
			.build();		
	}
	
	private static Aluno getAluno1() {
		return Aluno.builder()
				.nome(RandomStringUtils.randomAlphabetic(10))
				.idade(10)
			.build();		
	}

}
