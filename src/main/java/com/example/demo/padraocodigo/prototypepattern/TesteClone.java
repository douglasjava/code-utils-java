package com.example.demo.padraocodigo.prototypepattern;

public class TesteClone {

	public static void main(String[] args) throws CloneNotSupportedException {

		Prototype prototype = new Prototype("Douglas");

		System.out.println(prototype);
		System.out.println(prototype.getName());

		Prototype prototype2 = (Prototype) prototype.clone();

		System.out.println(prototype2.getName());
		System.out.println(prototype2);

		Prototype prototype3 = new Prototype("Débora");
		prototype3.setPerson(new Person(30));

		System.out.println(prototype3.getName() + " - " + prototype3.getPerson().getAge());

		System.out.println("--------------------------------");

		Prototype prototype4 = (Prototype) prototype3.clone();
		System.out.println(prototype4.getName() + " - " + prototype4.getPerson().getAge());

	}

}
