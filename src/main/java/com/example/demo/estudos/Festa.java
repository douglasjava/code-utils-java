package com.example.demo.estudos;

import java.util.Scanner;

public class Festa {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe a sua idade: ");
		int idadeUsuario = scan.nextInt();
		scan.nextLine();
		System.out.print("Informe se você trouxe bebida. Escreva sim ou não: ");
		String bebidaUsuario = scan.next();
		scan.close();
		
		System.out.println(validacaoFesta(idadeUsuario, bebidaUsuario));

	}
	
	
	public static String validacaoFesta(int idade, String bebida) {

		boolean trouxeBebida;

		if (bebida.equals("sim")) {
			trouxeBebida = true;
		} else {
			trouxeBebida = false;
		}
		
		if (idade >= 18 && trouxeBebida) {
			return "Você pode entrar na minha festa!";
		} else {
			return "Você não pode entrar na minha festa";
		}

	}

}
