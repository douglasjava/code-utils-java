package com.example.demo.andre;

public class TrianguloEquilatero implements Figura {

	@Override
	public double getArea(double x) {
		return (Math.pow(x, 2) * Math.sqrt(3)) / 4;
	}

}
