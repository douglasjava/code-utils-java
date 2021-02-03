package com.example.demo.andre;

public class Homem extends Primata {
	protected void ver() {
		System.out.println("Homem vendo");
	}
	public static void main(String[] args) {
		Mamifero mamifero = new Homem();
		mamifero.andar();
	}
}
