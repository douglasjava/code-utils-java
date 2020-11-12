package com.example.demo.andre;

public class AplicacaoInterface {

	public static void main(String[] args) {

		Figura circulo = new Circulo();
		Figura quadradoFigura = new Quadrado();
		Figura triangulo = new TrianguloEquilatero();

		System.out.println(circulo.getArea(10));
		System.out.println(quadradoFigura.getArea(10));
		System.out.println(triangulo.getArea(10));

	}

}
