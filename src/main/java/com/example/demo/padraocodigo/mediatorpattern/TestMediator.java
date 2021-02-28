package com.example.demo.padraocodigo.mediatorpattern;

public class TestMediator {

	public static void main(String[] args) {

		Mediator mediator = new MediatorImpl();

		// mediador ajuda a ajustar o aluguel e venda entre o cliente e o dono da casa
		mediator.handle("rent");
		mediator.handle("sale");

	}

}
