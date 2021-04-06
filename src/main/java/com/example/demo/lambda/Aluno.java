package com.example.demo.lambda;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class Aluno {

	private String nome;
	private Integer idade;

}
