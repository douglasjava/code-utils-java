package com.example.demo.solid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Funcionario {

	private Integer id;
	private String nome;
	private Double salario;
	private Cargo cargo;

	public double calculaSalario() {
		return this.cargo.getRegra().calcula(this);
	}
	
}
