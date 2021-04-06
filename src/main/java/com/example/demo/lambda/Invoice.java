package com.example.demo.lambda;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

	private String invoiceNo;
	private BigDecimal price;
	private BigDecimal qty;

}
