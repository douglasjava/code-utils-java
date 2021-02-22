package com.example.demo.padraocodigo.bridgepattern;

public class TestBrige {

	public static void main(String[] args) {

		Person man = new Man("Douglas");
		Person lady = new Lady("Débora");

		Clothing jacket = new Clothing("Jacket");
		Clothing trouser = new Clothing("Trouser");
		Clothing underpants = new Clothing("underpants");
		
		underpants.setPerson(man);

		man.setCloth(jacket);
		man.dress();

		man.setCloth(trouser);
		man.dress();

		lady.setCloth(jacket);
		lady.dress();

		lady.setCloth(trouser);
		lady.dress();
		
		man.setCloth(underpants);
		man.dress();
	}

}
