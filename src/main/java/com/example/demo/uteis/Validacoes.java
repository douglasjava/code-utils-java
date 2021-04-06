package com.example.demo.uteis;

public class Validacoes {

	public static void main(String[] args) {

		Integer i1 = 1;
		Integer i2 = 1;

		System.out.println(i1.compareTo(i2) == 0);
		
		System.out.println(i1 == i2);
		
		System.out.println(i2.equals(i2));
		
		
		Long l1 = 128L;
		Long l2 = 128L;

		System.out.println(l1.longValue() == l2.longValue());

	}

}
