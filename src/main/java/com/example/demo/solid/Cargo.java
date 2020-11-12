package com.example.demo.solid;

import lombok.Getter;

@Getter
public enum Cargo {
	
	DESENVOLVEDOR_SENIOR(new RegraVinteDoisEMeioPorcento()),
	DESENVOLVEDOR_JUNIOR(new RegraOnzePorcento());

	private RegraDeCalculo regra;

	private Cargo(RegraDeCalculo regra) {
		this.regra = regra;
	}

}
