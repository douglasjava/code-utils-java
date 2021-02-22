package com.example.demo.padraocodigo.chainofresponsibilitypattern;

public class ResignationHandler implements Handler {

	private Handler nextHandler;

	public ResignationHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	@Override
	public void handleRequest(StepResignation request) {

		if(StepResignation.RESIGNATION_APPLY.equals(request)) {
			System.out.println(request.getDescricao());
		}
		
		if(nextHandler != null) {
			nextHandler.handleRequest(StepResignation.FINANCIAL_REVIEW);
		}
		
	}

}
