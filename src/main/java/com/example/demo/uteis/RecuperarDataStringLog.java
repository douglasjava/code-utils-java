package com.example.demo.uteis;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

public class RecuperarDataStringLog {

	public static void main(String[] args) {

		String linha =  "Jan  9 11:30:31 MIBHCAMP11 smtp-uol/smtp[24974]: D13DCBDDF5A: to=<cfracari@uol.com.br>, relay=mx.uol.com.br[200.147.36.15]:25, delay=56196, delays=55920/275/0.09/0.22, dsn=4.7.1, status=deferred (host mx.uol.com.br[200.147.36.15] said: 450 4.7.1 <cfracari@uol.com.br>: Recipient address rejected: MX-UOL-02 - Too many messages, try again later. (in reply to RCPT TO command))";    		           		
		String dataCompleta = linha.substring(0, 16);
		
		String siglaMes = dataCompleta.substring(0,4).trim();
		Integer dia = Integer.valueOf(dataCompleta.substring(4,7).trim());
		String horaCompleta = dataCompleta.substring(7, dataCompleta.length() -1).trim();
		
		System.out.println(siglaMes);
		System.out.println(dia);
		System.out.println(horaCompleta);
		
		System.out.println(getLocalDateTime(dia, horaCompleta, siglaMes));
		
		
	}
	
	private static Month getMonth(String sigla) {
		return EnumMes.fromValue(sigla).getMonth();
	}

	private static LocalDateTime getLocalDateTime(Integer dia, String horaCompleta, String siglaMes) {
		Month mes = getMonth(siglaMes);
		
		String[] horaSeparada = horaCompleta.split(":");
		Integer hour = Integer.valueOf(horaSeparada[0]);
		Integer minute = Integer.valueOf(horaSeparada[1]);
		Integer seconds = Integer.valueOf(horaSeparada[2]);

		return LocalDateTime.of(Year.now().getValue(), mes, dia, hour, minute, seconds);
		
	}
}

