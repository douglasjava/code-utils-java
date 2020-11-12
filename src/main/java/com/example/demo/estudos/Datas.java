package com.example.demo.estudos;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Datas {

	
	public static void main(String[] args) {
		
		Date data = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println(simpleDateFormat.format(data));
		
		LocalDateTime dLocalDateTime = LocalDateTime.now();
		System.out.println(dLocalDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		
	}
	
}
