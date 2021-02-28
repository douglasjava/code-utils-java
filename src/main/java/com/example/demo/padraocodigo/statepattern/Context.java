package com.example.demo.padraocodigo.statepattern;

public class Context {

	private Flow flow;

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public void process() {
		this.flow.action();
	}

}
