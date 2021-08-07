package com.example.demo.padraocodigo.factoryPattern.mba;

public class ContactorFactory {

	public static ContatoIntF create(int type) {

		ContatoIntF contato = null;

		if (type == 0) {
			contato = new ContatoTelefone();
		} else if (type == 1) {
			contato = new ContatoEmail();
		} else if (type == 2) {
			contato = new ContatoSMS();
		}

		return contato;

	}

}
