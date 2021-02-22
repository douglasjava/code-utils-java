package com.example.demo.padraocodigo.commandPattern;

public class Mouse {

	public void click(Button btn) {
		ActionEvent event = new ActionEvent(btn.getText(), btn);
		btn.getActionListener().actionPerformed(event);
	}
	
}
