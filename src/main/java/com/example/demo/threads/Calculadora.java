package com.example.demo.threads;

public class Calculadora {

	private int soma;

	public synchronized int somaArray(int[] array) {
		this.soma = 0;

		try {
			
			for (int i = 0; i < array.length; i++) {
				this.soma += array[i];
				
				System.out.println("Executando a soma " + Thread.currentThread().getName() + " somando o valor " + array[i] + " com total de: " + soma);
				
				
				Thread.sleep(100);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		return this.soma;

	}

}
