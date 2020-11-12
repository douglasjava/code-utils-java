package com.example.demo.estudos;

public class Palindrome {

	public static void main(String[] args) {
		isPalindrome(12321);
		isPalindrome(23452);
		isPalindrome(21312);
	}

	private static void isPalindrome(int numero) {
		int reverse = 0;
		int copy = numero;

		while (copy != 0) {
			int remainder = copy % 10;
			reverse = (reverse * 10) + remainder;
			copy /= 10;			

		}
		
		String s;
		if (numero == reverse) {
			s = numero + " is a palindrome number";
		} else {
			s = numero + " is not a palindrome number";
		}

		System.out.println(s);
	}

}
