package com.example.demo.padraocodigo.chainofresponsibilitypattern;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StepResignation {

	RESIGNATION_APPLY("Redignation apply"), 
	FINANCIAL_REVIEW("Financial Review"), 
	MANAGER_REVIEW("Manager Review"), 
	APPROVAL("Okay"),
	APPROVAL_COMPLETED("Approval Completed");
	
	private String descricao;

}
