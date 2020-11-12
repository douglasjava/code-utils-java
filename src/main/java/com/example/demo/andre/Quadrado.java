package com.example.demo.andre;

public class Quadrado implements Figura {

	@Override
	public double getArea(double x) {
		return Math.pow(x, 2);
	}

}
