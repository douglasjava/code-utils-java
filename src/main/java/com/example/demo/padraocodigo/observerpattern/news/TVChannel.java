package com.example.demo.padraocodigo.observerpattern.news;

import lombok.Getter;
import lombok.Setter;

/**
 * observador
 * 
 * @author Marques
 *
 */
@Getter
@Setter
public class TVChannel implements Channel {

	private String news;

	@Override
	public void update(Object object) {
		System.out.println("Revista veja");
		this.setNews((String) object);
	}

}
