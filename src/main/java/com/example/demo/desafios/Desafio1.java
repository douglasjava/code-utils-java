package com.example.demo.desafios;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio1 {

	public static void main(String[] args) {

		Function<Produto, Double> precoFinal = produto -> produto.getPreco() * (1 - produto.getDesconto());
		UnaryOperator<Double> impostoMunicipal = preco -> preco >= 2500 ? preco * 1.085 : preco;
		UnaryOperator<Double> frete = preco -> preco >= 3000 ? preco + 100 : preco + 50;
		UnaryOperator<Double> arrendondar = preco ->  Double.parseDouble(String.format("%.2f", preco).replace(",", "."));
		Function<Double, String> formatar = preco -> ("R$ " + preco).replace(",", ".");
		
		Produto produto = new Produto("Ipad", 0.13 , 3235.89);
		String preco = precoFinal
					.andThen(impostoMunicipal)
					.andThen(frete)
					.andThen(arrendondar)
					.andThen(formatar)
				.apply(produto);		

		System.out.println(preco);

	}

}
