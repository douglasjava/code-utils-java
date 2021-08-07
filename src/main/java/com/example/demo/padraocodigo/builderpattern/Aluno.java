package com.example.demo.padraocodigo.builderpattern;

import java.math.BigDecimal;

public class Aluno {

	private String nome;
	private BigDecimal nota;
	private String sala;

	public String getNome() {
		return nome;
	}

	public Aluno setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public Aluno setNota(BigDecimal nota) {
		this.nota = nota;
		return this;
	}

	public String getSala() {
		return sala;
	}

	public Aluno setSala(String sala) {
		this.sala = sala;
		return this;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", nota=" + nota + ", sala=" + sala + "]";
	}

}
