package com.example.demo.provaMatheus;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat();

		// inicialização das variaveis.

		String nomeCliente;
		int cachorroQuente = 0;
		int bauruSimples = 0;
		int bauruComOvo = 0;
		int hamburguer = 0;
		int cheeseburguer = 0;
		int refrigerante = 0;
		double totalP100 = 0, totalP101 = 0, totalP102 = 0, totalP103 = 0, totalP104 = 0, totalP105 = 0;
		boolean sair = false;

		System.out.println(" -------- CARDÁPIO -------- "); // cardapio.
		System.out.println("");
		System.out.println("Especificação    Cod    Preço");
		System.out.println("Cachorro Quente  100    R$1,20");
		System.out.println("Bauru Simples    101    R$1,30");
		System.out.println("Bauru com ovo    102    R$1,50");
		System.out.println("Hambúrguer       103    R$1,20");
		System.out.println("Cheeseburguer    104    R$1,30");
		System.out.println("Refrigerante     105    R$1,00");

		// entrada de dados.

		System.out.print("digite o nome do cliente");
		nomeCliente = entrada.next();
	
		do {					
			
			System.out.print("Digite o código do produto pedido pelo cliente: ");
			int codProduto = entrada.nextInt();
			
			switch (codProduto) {
			case (100):
				System.out.print("Digite a quantidade do produto: ");

				cachorroQuente += (cachorroQuente = entrada.nextInt());
				totalP100 = 1.20 * cachorroQuente;

				break;
			case (101):
				System.out.println("Digite a quantidade do produto: ");

				bauruSimples += (bauruSimples = entrada.nextInt());
				totalP101 = 1.30 * bauruSimples;

				break;
			case (102):
				System.out.println("Digite a quantidade do produto: ");

				bauruComOvo += (bauruComOvo = entrada.nextInt());
				totalP102 = 1.50 * bauruComOvo;

				break;
			case (103):
				System.out.print("Digite a quantidade do produto: ");

				hamburguer += (hamburguer = entrada.nextInt());
				totalP103 = 1.20 * hamburguer;

				break;
			case (104):
				System.out.print("Digite a quantidade do produto: ");

				cheeseburguer += (cheeseburguer = entrada.nextInt());
				totalP104 = 1.30 * cheeseburguer;

				break;
			case (105):
				System.out.print("Digite a quantidade do produto: ");

				refrigerante += (refrigerante = entrada.nextInt());
				totalP105 = 1.00 * refrigerante;
				break;

			default:
				System.out.println("Codigo incorreto!\n");
				break;
			}
			
			System.out.print("Digite 1 para sair e 0 para continuar pedindo: ");
			int codExit = entrada.nextInt();
			
			if(codExit == 1) {
				sair = true;
			}
			
		} while (!sair);
				

		double total = totalP100 + totalP101 + totalP102 + totalP103 + totalP104 + totalP105; // Atribuição do total
																								// calculado na variável
																								// total.

		System.out.println("Total: R$ " + df.format(total)); // pedido final do cliente.

	}

}
