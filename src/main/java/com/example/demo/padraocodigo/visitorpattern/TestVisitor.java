package com.example.demo.padraocodigo.visitorpattern;

public class TestVisitor {

	public static void main(String[] args) {

		ObjectStructure objectStructure = new ObjectStructure();

		objectStructure.attach(new Man());
		objectStructure.attach(new Woman());

		Visitor sucess = new Success();
		objectStructure.display(sucess);

		Visitor amativeness = new Love();
		objectStructure.display(amativeness);

	}

}
