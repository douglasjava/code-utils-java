package com.example.demo.padraocodigo.observerpattern.news;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewspaperChannel implements Channel {

	private String news;

	@Override
	public void update(Object object) {
		System.out.println("Jornal nacional");
		this.setNews((String) object);
	}

}
