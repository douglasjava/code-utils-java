package com.example.demo.rest.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RespostaErro {

	private String status;
	private String type;
	private String title;
	private String detail;
	private String userMessage;
	private String timestamp;

}
