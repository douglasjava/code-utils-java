package com.example.demo.lista;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenarLista {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<>();

		alunos.add(new Aluno(60.0, "Douglas Dias", 3));
		alunos.add(new Aluno(10.0, "Aouglas Dias", 15));
		alunos.add(new Aluno(63.0, "Gouglas Dias", 96));
		alunos.add(new Aluno(10.0, "Rouglas Dias", 63));
		alunos.add(new Aluno(35.0, "Douglas Dias", 8));
		alunos.add(new Aluno(42.0, "Pouglas Dias", 30));
		alunos.add(new Aluno(90.0, "Youglas Dias", 55));
		alunos.add(new Aluno(2.0, "Rouglas Dias", 12));

		alunos.forEach(System.out::println);
		
		System.out.println("---------------");

		alunos.stream().sorted(Comparator.comparing(Aluno::getIdade)).forEach(System.out::println);

		System.out.println("---------------");
		
		alunos.stream().sorted(Comparator.comparing(Aluno::getNome)).forEach(System.out::println);

		System.out.println("---------------");
		
		alunos.stream().sorted(Comparator.comparing(Aluno::getNota)).forEach(System.out::println);
	}

}
