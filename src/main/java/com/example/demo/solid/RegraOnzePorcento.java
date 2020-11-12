package com.example.demo.solid;

public class RegraOnzePorcento implements RegraDeCalculo {

	@Override
	public double calcula(Funcionario funcionario) {
		return funcionario.getSalario() - (funcionario.getSalario() * 0.11);
	}

}
