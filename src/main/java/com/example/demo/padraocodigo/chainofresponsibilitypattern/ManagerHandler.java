package com.example.demo.padraocodigo.chainofresponsibilitypattern;

public class ManagerHandler implements Handler {

	private Handler nextHandler;

	public ManagerHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	
	@Override
	public void handleRequest(StepResignation request) {

		if(StepResignation.MANAGER_REVIEW.equals(request)) {
			System.out.println(request.getDescricao());
		}
		
		if(nextHandler != null) {
			nextHandler.handleRequest(StepResignation.APPROVAL);
		}

	}

}
