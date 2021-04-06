package com.example.demo.diego.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainOrdenacao {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<>();

		Aluno aluno1 = new Aluno("Teste0", 7, "1");
		Aluno aluno2 = new Aluno("Teste1", 3, "2");
		Aluno aluno3 = new Aluno("Teste2", 5, "3");
		Aluno aluno4 = new Aluno("Teste3", 1, "4");
		Aluno aluno5 = new Aluno("Teste4", 9, "5");

		alunos.add(aluno1);
		alunos.add(aluno2);
		alunos.add(aluno3);
		alunos.add(aluno4);
		alunos.add(aluno5);

		System.out.println("----------------------");

		System.out.println("    SEM ORDENAÇÃO     ");

		System.out.println("----------------------");

		alunos.forEach(aluno -> System.out.println(aluno.getNome() + " - " + aluno.getNota()));

		System.out.println("----------------------");

		System.out.println("    COM ORDENAÇÃO ASC ");

		System.out.println("----------------------");

		// Criar ordenador com Lambda
		Comparator<Aluno> compareById = (Aluno o1, Aluno o2) -> o1.getNota().compareTo(o2.getNota());

		// Criar ordenador sem Lambda
		Comparator<Aluno> compareByIdSemlambda = new Comparator<Aluno>() {
		    @Override
		    public int compare(Aluno o1, Aluno o2) {
		        return o1.getNota().compareTo(o2.getNota());
		    }
		};

		Collections.sort(alunos, compareById);

		alunos.forEach(aluno -> System.out.println(aluno.getNome() + " - " + aluno.getNota()));

		System.out.println("----------------------");

		System.out.println("    COM ORDENAÇÃO DESC ");

		System.out.println("----------------------");

		Collections.sort(alunos, compareById.reversed());

		alunos.forEach(aluno -> System.out.println(aluno.getNome() + " - " + aluno.getNota()));

	}

}
