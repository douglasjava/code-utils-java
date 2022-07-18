package com.example.demo.certificado;

import java.io.*;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.apache.xml.security.Init;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.ElementProxy;
import org.w3c.dom.Document;

public class CreateSignature {

    private static final String PRIVATE_KEY_ALIAS = "test-alias";
    private static final String PRIVATE_KEY_PASS = "test";
    private static final String KEY_STORE_PASS = "test";
    private static final String KEY_STORE_TYPE = "JKS";

    public static void main(String... unused) throws Exception {
        final InputStream fileInputStream = new FileInputStream("test.xml");
        try {
            output(signFile(fileInputStream, new File("keystore.jks")), "signed-test.xml");
        }
        finally {
            IOUtils.closeQuietly(fileInputStream);
        }
    }

    public static ByteArrayOutputStream signFile(InputStream xmlFile, File privateKeyFile) throws Exception {
        final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
        Init.init();
        ElementProxy.setDefaultPrefix(Constants.SignatureSpecNS, "");
        final KeyStore keyStore = loadKeyStore(privateKeyFile);
        final XMLSignature sig = new XMLSignature(doc, null, XMLSignature.ALGO_ID_SIGNATURE_RSA);
        final Transforms transforms = new Transforms(doc);
        transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
        sig.addDocument("", transforms, Constants.ALGO_ID_DIGEST_SHA1);
        final Key privateKey = keyStore.getKey(PRIVATE_KEY_ALIAS, PRIVATE_KEY_PASS.toCharArray());
        final X509Certificate cert = (X509Certificate)keyStore.getCertificate(PRIVATE_KEY_ALIAS);
        sig.addKeyInfo(cert);
        sig.addKeyInfo(cert.getPublicKey());
        sig.sign(privateKey);
        doc.getDocumentElement().appendChild(sig.getElement());
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_WITH_COMMENTS).canonicalizeSubtree(doc));
        return outputStream;
    }

    private static KeyStore loadKeyStore(File privateKeyFile) throws Exception {
        final InputStream fileInputStream = new FileInputStream(privateKeyFile);
        try {
            final KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
            keyStore.load(fileInputStream, KEY_STORE_PASS.toCharArray());
            return keyStore;
        }
        finally {
            IOUtils.closeQuietly(fileInputStream);
        }
    }

    private static void output(ByteArrayOutputStream signedOutputStream, String fileName) throws IOException {
        final OutputStream fileOutputStream = new FileOutputStream(fileName);
        try {
            fileOutputStream.write(signedOutputStream.toByteArray());
            fileOutputStream.flush();
        }
        finally {
            IOUtils.closeQuietly(fileOutputStream);
        }
    }
}