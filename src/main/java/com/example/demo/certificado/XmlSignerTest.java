package com.example.demo.certificado;


import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.io.IOUtils;

/**
 * How to use XmlSigner
 */
public class XmlSignerTest {

    private static final Logger logger = LoggerFactory.getLogger(XmlSignerTest.class);

    //@Test
    public void shouldSignXmlUsingAJavaKeyStore() throws Exception {
        // scenario
        InputStream xml = XmlSigner.class.getResourceAsStream("/xml-document-sample.xml");
        InputStream jks = XmlSigner.class.getResourceAsStream("/my-private-key.jks");

        String alias = "root";
        String password = "secret";

        // action
        SignedXml signedXml = new XmlSigner()
                .withXml( "\n<request> "
                        + "\n    <another-tag name='foo' /> "
                        + "\n</request> ")  // it supports InputStream as well
                .withKeyStore(jks, alias, password)
                .sign();

        // validation
        String content = signedXml.getContent();
        logger.info("\n" + content); // just prints the result

        //assertThat(content).contains("<X509Certificate>").contains("</X509Data>").contains("</Signature>");
    }
}