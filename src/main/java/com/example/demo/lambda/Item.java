package com.example.demo.lambda;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Item {

	private String name;
	private Integer qtde;
	private BigDecimal valor;

}
