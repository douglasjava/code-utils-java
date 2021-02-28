package com.example.demo.padraocodigo.statepattern;

public class TestFlowState {

	public static void main(String[] args) {

		Context context = new Context();

		context.setFlow(new ApplyFlow());
		context.process();

		context.setFlow(new VerfiyFlow());
		context.process();

		context.setFlow(new ApproveFlow());
		context.process();

	}

}
