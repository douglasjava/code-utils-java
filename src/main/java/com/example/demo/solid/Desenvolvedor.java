package com.example.demo.solid;

public class Desenvolvedor extends Funcionario2 {

	private double salario;

	public Desenvolvedor(double salario) {
		this.salario = salario;
	}

	@Override
	public double getSalario() {
		return this.salario;
	}

}
