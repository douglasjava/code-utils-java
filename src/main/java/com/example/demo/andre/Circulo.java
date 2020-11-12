package com.example.demo.andre;

public class Circulo implements Figura {

	@Override
	public double getArea(double x) {
		return Math.PI * Math.pow(x, 2);
	}

}
