package com.example.demo.solid;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Funcionario2 implements Convencional {

	private String nome;
	private double salario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
