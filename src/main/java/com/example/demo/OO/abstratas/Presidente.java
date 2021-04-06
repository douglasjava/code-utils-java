package com.example.demo.OO.abstratas;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class Presidente extends Funcionario {

	private BigDecimal salario;

	@Override
	BigDecimal getBonificacao() {
		return this.salario.multiply(BigDecimal.valueOf(10));
	}

}
