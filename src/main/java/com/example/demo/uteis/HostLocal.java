package com.example.demo.uteis;

import java.util.Objects;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

public class HostLocal {

	private static HttpServletRequest request;
	
	public static void main(String[] args) {
		
		String xRealIp = request.getHeader("X-Real-IP");
		String xForwasrdeFor = request.getHeader("X-Forwarded-For");
		String remoteAddr = request.getRemoteAddr();
		
		String resultado = Stream.of(xRealIp, xForwasrdeFor, remoteAddr)
				.filter(Objects::nonNull)
				.findFirst().orElse("");
		
		System.out.println(resultado);
		
	}
	
	
	
}
