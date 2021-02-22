package com.example.demo.padraocodigo.chainofresponsibilitypattern;

public class ApprovalCompled implements Handler {

	@Override
	public void handleRequest(StepResignation request) {

		if (StepResignation.APPROVAL_COMPLETED.equals(request)) {
			System.out.println(request.getDescricao());
		}

	}

}
