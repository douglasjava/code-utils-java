package com.example.demo.padraocodigo.facadepattern;

/**
 * Fornece uma interface consistente para chamar interfaces.
 * 
 * @author Marques
 *
 */
public class Facade {

	private Light light;
	private Music music;
	private Video video;

	public Facade() {
		this.light = new LightImpl();
		this.music = new MusicImpl();
		this.video = new VideoImpl();
	}

	public void sign() {
		System.out.println("Start singing with");
		this.light.flash();
		this.music.play();
	}

	public void dance() {
		System.out.println("Start dancing with");
		this.light.flash();
		this.music.play();
		this.video.show();
	}

	public void act() {
		System.out.println("Start acting with");
		this.light.flash();
		this.video.show();
	}

}
