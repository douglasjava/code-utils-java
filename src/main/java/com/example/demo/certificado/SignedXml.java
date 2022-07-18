package com.example.demo.certificado;

import java.util.Base64;

/**
 * Represents a signed XML
 */
public class SignedXml {

    private String content;

    public SignedXml(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String toBase64() {
        String base64Xml = Base64.getEncoder().encodeToString(content.getBytes());
        return base64Xml;
    }
}