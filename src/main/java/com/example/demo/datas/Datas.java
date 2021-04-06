package com.example.demo.datas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static final String ISO8601_DATE = "yyyy-MM-dd";

	public static void main(String[] args) {
		
		System.out.println(LocalDate.now());

		gerarData();
		
		System.out.println(BigDecimal.valueOf(1.00));
		System.out.println(new BigDecimal(1.00));
		
		System.out.println(); 
		
		String dataAtual = "2021-05-06";
		
		LocalDate.parse(dataAtual, DateTimeFormatter.ofPattern(ISO8601_DATE));

	}

	private static void gerarData() {

		var dataAtual = LocalDateTime.of(Year.now().getValue(), Month.JANUARY, 1, 0, 0, 0);
		System.out.println(dataAtual.minusMonths(1).toLocalDate().toString());

		for (int i = 0; i < 14; i++) {
			System.out.println(dataAtual.plusMonths(i).toLocalDate().toString());
		}

	}

}
