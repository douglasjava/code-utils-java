package com.example.demo.padraocodigo.mediatorpattern;

public class MediatorImpl implements Mediator {

	private HouseOwner owner1;
	private HouseOwner owner2;

	public MediatorImpl() {
		owner1 = new HouseRent();
		owner2 = new HouseSale();
	}

	@Override
	public void handle(String content) {
		if ("rent".equals(content)) {
			this.owner1.action();

		} else if ("sale".equals(content)) {
			this.owner2.action();

		}

	}

}
