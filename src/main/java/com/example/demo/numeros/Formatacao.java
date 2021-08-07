package com.example.demo.numeros;

public class Formatacao {

	public static void main(String[] args) {

		String number = "000006581116";

		System.out.println(getNumberFormatted(number));
		
		String n = "000006581116";
		StringBuilder sb = new StringBuilder(n);
	    sb.insert(5, ",");
	    System.out.println(sb.toString());
		
	}

	private static String getNumberFormatted(String number) {
		if (number.length() != 12) {
			throw new IllegalArgumentException("Valor fora do padrão permitido");
		}

		int antesVirgula = Integer.parseInt(number.substring(0, 5));
		String depoisVirgula = number.substring(5, number.length());

		String numeroFormatado = antesVirgula + "," + depoisVirgula;

		return numeroFormatado;
	}

}
