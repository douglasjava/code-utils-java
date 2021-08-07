package com.example.demo.padraocodigo.builderpattern;

import java.math.BigDecimal;

public class MainBuilder {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		
		aluno.setNome("Douglas Dias")
			.setNota(BigDecimal.valueOf(7.5))
			.setSala("A11");
		
		System.out.println(aluno);
		
	}
	
}
