package com.example.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

/**
 * Explicação
 * <p>
 * 
 * - <b>(n1, n2)</b> vai pegar o primeiro e segundo item da lista
 * <p>
 * Vai aplicar a função <b>n1 + n2</b> nos dois primeiros, no caso vai somar
 * <b>1 + 2</b>
 * <p>
 * e o resultado que é <b>3</b> será o n1 no próximo loop executando a função
 * com os valores 3 + 3
 * <p>
 * <p>
 * 
 * - Função
 * <p>
 * Pegar todos os elementos da Coleção e transformar em um só
 * 
 * @author Marques
 *
 */
public class Reduce01 {

	public static void main(String[] args) {

		List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);
		List<Integer> numerosVazio = List.of();

		numeros.stream().forEach(System.out::println);

		reduceSoma(numeros);

		reduceMultiplicacao(numeros);

		reduceConcatenacao();

		reduceSoma2(numerosVazio);

		reduceMultiplicacao2(numerosVazio);

		reduceConcatenacao2();
		
		reduceDouble();
		
		reduceDouble2();
		
		reduceSoma3(numeros);
	}

	private static void reduceSoma(List<Integer> numeros) {
		Optional<Integer> numeroOpt = numeros.stream().reduce((n1, n2) -> n1 + n2);

		System.out.println(numeroOpt.get());
	}

	private static void reduceMultiplicacao(List<Integer> numeros) {
		Optional<Integer> numeroOpt = numeros.stream().reduce((n1, n2) -> n1 * n2);

		System.out.println(numeroOpt.get());
	}

	private static void reduceConcatenacao() {
		String s = "Inscreva-se no canal e comparilhe esse video";
		String[] arr = s.split(" ");
		List<String> listaStr = Arrays.asList(arr);

		Optional<String> stringOpt = listaStr.stream().reduce((s1, s2) -> s1.concat(s2));

		System.out.println(stringOpt.get());

	}

	/**
	 * Não é uma boa prática, podem ocorrer vários retornos, pois não é uma função
	 * associativa, conforme o contrato pede
	 * <p>
	 * NÃO USAR
	 * 
	 * @param numeros
	 */
	@SuppressWarnings("unused")
	private static void reduceSubtracao(List<Integer> numeros) {
		Optional<Integer> numeroOpt = numeros.stream().reduce((n1, n2) -> n1 - n2);

		System.out.println(numeroOpt.get());

	}

	/**
	 * Com o parametro de identidade e o número de identificação não pode alterar o
	 * valor pq o stream vai utiliza-lo como o primeiro número o n1 ficando 0 + 1 ->
	 * o primeiro item da lista
	 * 
	 * @param numeros
	 */
	private static void reduceSoma2(List<Integer> numeros) {
		Integer numero = numeros.stream().reduce(0, (n1, n2) -> n1 + n2);

		System.out.println(numero);
	}

	private static void reduceMultiplicacao2(List<Integer> numeros) {
		Integer numero = numeros.stream().reduce(1, (n1, n2) -> n1 * n2);

		System.out.println(numero);
	}

	private static void reduceConcatenacao2() {
		String s = "Inscreva-se no canal e comparilhe esse video";
		String[] arr = s.split(" ");
		List<String> listaStr = Arrays.asList(arr);

		String string = listaStr.stream().reduce("", (s1, s2) -> s1.concat(s2));

		System.out.println(string);

	}

	private static void reduceDouble() {
		DoubleStream lista = DoubleStream.of(1.5, 2.9, 2.5);
				
		//lista.forEach(System.out::println);
		
		OptionalDouble menor = lista.reduce((d1,d2) -> Math.min(d1, d2));		
		System.out.println(menor.getAsDouble());
	
	}
	
	private static void reduceDouble2() {
		DoubleStream lista = DoubleStream.of(1.5, 2.9, 2.5);
				
		double menorValor = lista.reduce(Double.POSITIVE_INFINITY, (d1,d2) -> Math.min(d1, d2));		
		System.out.println(menorValor);
		
	}


	/**
	 * Função de combinação 3º parametros
	 * Só chama quando quando usar o parelelo
	 * @param numeros
	 */
	private static void reduceSoma3(List<Integer> numeros) {
		Integer numero = numeros.stream().reduce(0, (n1,n2) -> n1 + n2, (n1,n2) -> n1 + n2);

		System.out.println(numero);
	}
	
}
