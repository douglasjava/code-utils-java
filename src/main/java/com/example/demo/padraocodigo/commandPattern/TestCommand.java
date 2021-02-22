package com.example.demo.padraocodigo.commandPattern;

public class TestCommand {

	public static void main(String[] args) {

		Button btnOk = new Button("OK");
		Button btnCancel = new Button("Cancel");

		btnOk.addActionListener((a) -> System.out.println(a.getName() + " button is clicked"));

		btnCancel.addActionListener((a) -> System.out.println(a.getName() + " button is clicked"));

		Mouse mouse = new Mouse();
		mouse.click(btnOk);
		mouse.click(btnCancel);

	}

}
