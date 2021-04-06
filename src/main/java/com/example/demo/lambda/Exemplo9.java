package com.example.demo.lambda;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Exemplo9 {

	public static void main(String[] args) {
		
		Invoice invoice1 = new Invoice("A", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1));
		Invoice invoice2 = new Invoice("A02", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5));
		Invoice invoice3 = new Invoice("A03", BigDecimal.valueOf(4.99), BigDecimal.valueOf(2));
		
		List<Invoice> invoices = List.of(invoice1, invoice2, invoice3);

        BigDecimal sum = invoices.stream()
                .map(x -> x.getQty().multiply(x.getPrice()))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add);      // reduce

        System.out.println(sum);    // 49.955
        System.out.println(sum.setScale(2, RoundingMode.HALF_UP));  // 49.96

		
		
	}
	

}
