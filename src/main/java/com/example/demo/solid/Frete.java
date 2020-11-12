package com.example.demo.solid;

public class Frete implements ServicoDeFrete {

	@Override
	public double calculaFrete(Estado estado) {
		if (Estado.SAO_PAULO.equals(estado)) {
			return 7.5;

		} else if (Estado.MINAS_GERAIS.equals(estado)) {
			return 12.5;

		} else if (Estado.RIO_DE_JANEIRO.equals(estado)) {
			return 10.5;

		} else {
			return 10.0;

		}
	}

}
