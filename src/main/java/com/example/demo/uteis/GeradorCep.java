package com.example.demo.uteis;

import java.util.Random;

public class GeradorCep {

	/**
	 * 32141-012
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Random rnd = new Random();
		int numero1 = rnd.nextInt(10);
		int numero2 = rnd.nextInt(10);
		int numero3 = rnd.nextInt(10);
		int numero4 = rnd.nextInt(10);
		int numero5 = rnd.nextInt(10);
		int numero6 = rnd.nextInt(10);
		int numero7 = rnd.nextInt(10);
		int numero8 = rnd.nextInt(10);

		StringBuilder sb = new StringBuilder();
		sb.append(numero1);
		sb.append(numero2);
		sb.append(numero3);
		sb.append(numero4);
		sb.append(numero5);
		sb.append("-");
		sb.append(numero6);
		sb.append(numero7);
		sb.append(numero8);

		System.out.println(sb.toString());

	}

}
