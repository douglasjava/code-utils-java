package com.example.demo.padraocodigo.compositePattern;

public class TestTree {

	public static void main(String[] args) {

		Tree tree = new Tree("World");
		Node root = tree.getRoot();

		Node china = new Node("China");
		Node america = new Node("America");

		root.add(china);
		root.add(america);

		Node beijing = new Node("Bei Jing");
		Node shanghai = new Node("Shanghai");

		china.add(beijing);
		china.add(shanghai);

		Node saoFrancisco = new Node("San Francisco");
		Node newyork = new Node("New York");

		america.add(saoFrancisco);
		america.add(newyork);

		System.out.println(root.getName());

		for (Node node1 : root.getChildNodes()) {
			System.out.println("--- " + node1.getName());

			for (Node node2 : node1.getChildNodes()) {
				System.out.println("----- " + node2.getName());

			}

		}

	}

}
