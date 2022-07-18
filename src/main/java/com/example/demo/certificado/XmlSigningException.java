package com.example.demo.certificado;

public class XmlSigningException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public XmlSigningException(String message) {
        super(message);
    }

    public XmlSigningException(String message, Throwable cause) {
        super(message, cause);
    }

}