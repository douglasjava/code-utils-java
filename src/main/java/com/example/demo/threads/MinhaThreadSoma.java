package com.example.demo.threads;

public class MinhaThreadSoma implements Runnable {

	private String nome;
	private int[] nums;
	private static Calculadora calc = new Calculadora();

	public MinhaThreadSoma(String nome, int[] nums) {
		this.nome = nome;
		this.nums = nums;
		new Thread(this, nome).start();
	}

	@Override
	public void run() {

		System.out.println("Iniciar: " + this.nome);

		int soma = calc.somaArray(nums);

		System.out.println("Resultado da soma para a Thread " + this.nome + " é: " + soma);

		System.out.println("Final: " + this.nome);
	}

}
