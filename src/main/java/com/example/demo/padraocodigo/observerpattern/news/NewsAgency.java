package com.example.demo.padraocodigo.observerpattern.news;

import java.util.ArrayList;
import java.util.List;

/**
 * NewsAgency é observável quando as notícias são atualizadas, o estado de
 * NewsAgency muda. Quando a mudança acontece, NewsAgency notifica os
 * observadores sobre esse fato chamando seu método update()
 * 
 * @author Marques
 *
 */
public class NewsAgency {

	private String news;
	private List<Channel> channels = new ArrayList<>();

	public void addObserver(Channel channel) {
		this.channels.add(channel);
	}

	public void removeObserver(Channel channel) {
		this.channels.remove(channel);
	}

	public void setNews(String news) {
		this.news = news;
		for (Channel channel : this.channels) {
			channel.update(this.news);
		}
	}

}
