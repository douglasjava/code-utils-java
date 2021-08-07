package com.example.demo.threads;

public class Teste5 {

	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5};
		MinhaThreadSoma soma1 = new MinhaThreadSoma("#1", array);
		MinhaThreadSoma soma2 = new MinhaThreadSoma("#2", array);
		
	}
	
}
