package com.example.demo.andre;

public class Atividade5 {

	public static void main(String[] args) {

		int numero = 10;
		String texto = "ABC";
		char letra = 'X';
		
		numero *= 5;
		
		boolean val1 = (numero > 40 && texto.equals("ABC") || letra == 'X');
		boolean val2 = (numero < 40 && texto.equals("AAA") || letra != 'X');
		boolean val3 = (numero > 50 || texto.equals("ABC") && letra == 'X');
		boolean val4 = (numero < 60 || texto.equals("AAA") || letra == 'X');
		boolean val5 = (numero > 50 && texto.equals("ABC") && letra == 'X');
		
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
		System.out.println(val4);
		System.out.println(val5);
		
	}

}
