package com.example.demo.padraocodigo.chainofresponsibilitypattern;

public class ApprovalHandler implements Handler {

	private Handler nextHandler;

	public ApprovalHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	@Override
	public void handleRequest(StepResignation request) {

		if(StepResignation.APPROVAL.equals(request)) {
			System.out.println(request.getDescricao());
		}
		
		if(nextHandler != null) {
			nextHandler.handleRequest(StepResignation.APPROVAL_COMPLETED);
		}

	}

}
