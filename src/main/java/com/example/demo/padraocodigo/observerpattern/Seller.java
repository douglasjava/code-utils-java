package com.example.demo.padraocodigo.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class Seller implements Observer {

	public Seller(Observable o) {
		o.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof StockData) {
			StockData data = (StockData) o;
			System.out.println("Seller Price: " + data.getPrice());
		}

	}

}
