package com.example.demo.padraocodigo.observerpattern;

import java.util.Observable;

/**
 * {@code Observable} foi descontinuada a partir do java 9 Para confiável e
 * ordenado mensagens entre threads, considere usar um dos dados simultâneos
 * estruturas no pacote {@link java.util.concurrent}. Para programação de estilo
 * de fluxos reativos, consulte o API {@link java.util.concurrent.Flow}.
 * <p>
 * - Nesse exemplo vamos utilizar o Observable a titulo de entendimento do
 * padrão
 * 
 * @author Marques
 * 
 */
public class StockData extends Observable {

	private float price;

	public StockData(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setStockData(float price) {
		this.price = price;
		setChanged();
		notifyObservers();
	}

}
