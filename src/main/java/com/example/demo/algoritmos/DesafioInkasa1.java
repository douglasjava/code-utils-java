package com.example.demo.algoritmos;

public class DesafioInkasa1 {

	public static void main(String[] args) {

		intervalo(10, 15);

	}

	public static void intervalo(int x, int y) {

		if (y < x) {
			throw new IllegalArgumentException("Segundo número tem que ser maior que primeiro");
		}

		for (int i = x + 1; i < y; i++) {
			System.out.println(i);
		}

	}

}
