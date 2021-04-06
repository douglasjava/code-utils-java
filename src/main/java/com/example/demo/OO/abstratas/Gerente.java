package com.example.demo.OO.abstratas;

import java.math.BigDecimal;

public class Gerente extends Funcionario {

	private BigDecimal salario;

	@Override
	BigDecimal getBonificacao() {
		return this.salario.multiply(BigDecimal.valueOf(5));
	}

}
