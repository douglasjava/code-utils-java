package com.example.demo;

public class Teste {

	public static void main(String[] args) {

		Integer valor = 5;

		if (valor == 100) {
			System.out.println("icons8-bateria-cheia-100 - VERDE");
		} else if (valor >= 75 || valor > 50) {
			System.out.println("icons8-bateria-carregada-100 - VERDE");
		} else if (valor >= 50 || valor > 25) {
			System.out.println("icons8-bateria-pela-metade-100 - LARANJA");
		} else if (valor >= 25 || valor > 15) {
			System.out.println("icons8-bateria-fraca-100 - VERMELHO");
		} else if (valor <= 15) {
			System.out.println("icons8-alerta-de-bateria-100 - VERMELHO");
		}

	}

}
