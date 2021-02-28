package com.example.demo.padraocodigo.observerpattern;

public class TestObserver {

	public static void main(String[] args) {
		
		StockData data = new StockData(16.9f);
		
		Buyer buyer = new Buyer(data);
		Seller seller = new Seller(data);
		
		data.setStockData(18.9f);
		
		System.out.println("---------------");
		
		data.setStockData(12.9f);
		
	}
	
	
}
