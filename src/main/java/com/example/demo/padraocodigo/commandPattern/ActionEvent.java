package com.example.demo.padraocodigo.commandPattern;

public class ActionEvent {

	private String name;
	private Object source;

	public ActionEvent(String name, Object source) {
		super();
		this.name = name;
		this.source = source;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

}
