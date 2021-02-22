package com.example.demo.padraocodigo.compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marques
 *
 */
public class Node {

	protected String name;
	protected List<Node> childNodes;

	public Node(String name) {
		this.name = name;
		this.childNodes = new ArrayList<>();
	}

	public void add(Node node) {
		this.childNodes.add(node);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getChildNodes() {
		return childNodes;
	}

}
