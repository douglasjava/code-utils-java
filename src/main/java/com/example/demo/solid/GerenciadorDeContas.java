package com.example.demo.solid;

import lombok.Getter;

@Getter
public class GerenciadorDeContas {

	private double saldo;

	public void deposita(double valor) {
		this.saldo += valor;
	}

	public void saca(double valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;

		} else {
			throw new IllegalArgumentException("Saldo insuficiente.");

		}
	}

	public void rende(double taxa) {
		this.saldo = this.saldo + (this.saldo * taxa);
	}

}
