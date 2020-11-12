package com.example.demo.diego;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
	
	public static void main(String[] args) {
		Gigasecond gigasecond = new Gigasecond(LocalDateTime.now()); 
		System.out.println(gigasecond.getDateTime());
	}

	public LocalDateTime validLocalDateTime;
	public static final int GIGASECOND = 1000000000;
	
	public Gigasecond(LocalDateTime moment) {
		this.validLocalDateTime = moment;
	}
	
	public Gigasecond(LocalDate moment) {
		this(moment.atStartOfDay());
	}
	
	public LocalDateTime getDateTime() {
		return validLocalDateTime.plusSeconds(GIGASECOND);
	}

}