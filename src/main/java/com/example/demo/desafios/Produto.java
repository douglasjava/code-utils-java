package com.example.demo.desafios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Produto {

	private String nome;
	private Double desconto;
	private Double preco;
	
	public Double getPrecoComFrete() {
		return this.preco + 100;
	}
	
	public Double getPrecoSemFrete() {
		return this.preco + 50;
	}

}
