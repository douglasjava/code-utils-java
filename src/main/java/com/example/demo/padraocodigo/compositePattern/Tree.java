package com.example.demo.padraocodigo.compositePattern;

/**
 * @author Marques
 *
 */
public class Tree {

	private Node root;
	protected String name;

	public Tree(String name) {
		this.root = new Node(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getRoot() {
		return root;
	}

}
