package com.example.demo.hundreddaysofjava;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

/**
 * Day 2 - Formatting a LocalDateTime object.
 */
@Slf4j
public class Day002 {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

	public static void main(String[] args) {

		LocalDateTime currentDateTime = LocalDateTime.now();
		String formattedDateTime = currentDateTime.format(FORMATTER);
		log.info(formattedDateTime);
		
	}

}
