package com.example.demo.padraocodigo.observerpattern.news;

public class TesteNews {

	public static void main(String[] args) {

		NewsAgency observable = new NewsAgency();
		TVChannel observer = new TVChannel();
		NewspaperChannel observer1 = new NewspaperChannel();

		observable.addObserver(observer);
		observable.addObserver(observer1);

		observable.setNews("news");

	}

}
