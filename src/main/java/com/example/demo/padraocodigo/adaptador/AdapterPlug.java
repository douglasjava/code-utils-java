package com.example.demo.padraocodigo.adaptador;

public class AdapterPlug implements Plug {

	@Override
	public int recharge() {
		HighVoltagePlug bigPlug = new HighVoltagePlug();

		int voltagem = bigPlug.recharge();

		voltagem = voltagem - 64;

		return voltagem;

	}

}
