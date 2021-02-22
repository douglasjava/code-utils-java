package com.example.demo.padraocodigo.chainofresponsibilitypattern;

public class TestHandler {

	public static void main(String[] args) {

		Handler approvalCompled = new ApprovalCompled();
		Handler approval = new ApprovalHandler(approvalCompled);
		Handler manager = new ManagerHandler(approval);
		Handler finance = new FinanceHandler(manager);
		Handler resignation = new ResignationHandler(finance);

		resignation.handleRequest(StepResignation.RESIGNATION_APPLY);

	}

}
