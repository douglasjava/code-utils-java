package com.example.demo.padraocodigo.chainofresponsibilitypattern;

public class FinanceHandler implements Handler {

	private Handler nextHandler;

	public FinanceHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public void handleRequest(StepResignation request) {

		if(StepResignation.FINANCIAL_REVIEW.equals(request)) {
			System.out.println(request.getDescricao());
		}
		
		if(nextHandler != null) {
			nextHandler.handleRequest(StepResignation.MANAGER_REVIEW);
		}

	}

}
