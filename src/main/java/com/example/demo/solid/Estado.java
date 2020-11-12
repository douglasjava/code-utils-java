package com.example.demo.solid;

import lombok.Getter;

@Getter
public enum Estado {

	SAO_PAULO("SAO PAULO"), 
	MINAS_GERAIS("MINAS GERAIS"), 
	RIO_DE_JANEIRO("RIO DE JANEIRO");

	private String descricao;

	private Estado(String descricao) {
		this.descricao = descricao;
	}
}
