package com.example.demo.padraocodigo.commandPattern;

public class Button {

	private ActionListener actionListener;
	private String text;

	public Button(String text) {
		super();
		this.text = text;
	}
	
	public ActionListener getActionListener() {
		return this.actionListener;
	}

	public void addActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
