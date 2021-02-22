package com.example.demo.padraocodigo.builderpattern;

public class ConcreteBuilder implements Builder {

	private Car car = null;

	public ConcreteBuilder() {
		this.car = new Car();
	}

	@Override
	public void buildHead() {
		car.setHead("Car head construction completed");
	}

	@Override
	public void buildBody() {
		car.setBody("Car body construction completed");
	}

	@Override
	public void buildWheel() {
		car.setWheel("Car wheel construction completed");
	}

	@Override
	public Car builPart() {
		return car;
	}

}
