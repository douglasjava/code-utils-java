package com.example.demo.datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class OffSetData {

	public static void main(String[] args) {

		Date agora = new Date();
		
		System.out.println(agora.toInstant().atOffset(ZoneOffset.UTC));
		
		System.out.println(agora.toInstant().atOffset(OffsetDateTime.now().getOffset()));

		
		String dataTimeErrada = "2021-04-31 00:00:00";
		
		System.out.println(LocalDateTime.parse(dataTimeErrada, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
		String dataErrada = "2021-04-31";
		
		System.out.println(LocalDate.parse(dataErrada, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		
		System.out.println("-------------");
		
		OffsetDateTime d = OffsetDateTime.parse("2017-05-16 02:09:10",
                DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"));
        System.out.println(d);
	}

}
