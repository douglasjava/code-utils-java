package com.example.demo.kafka.vendas_ingressos.exception;

public class SerializeDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SerializeDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public SerializeDataException(String message) {
		super(message);
	}

}
