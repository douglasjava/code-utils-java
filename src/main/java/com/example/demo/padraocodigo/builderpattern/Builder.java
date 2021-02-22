package com.example.demo.padraocodigo.builderpattern;

public interface Builder {

	public void buildHead();

	public void buildBody();

	public void buildWheel();

	public Car builPart();
}
