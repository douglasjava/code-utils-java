package com.example.demo.certificado;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Responsible for signing a specific XML using private key certificate
 */
public class XmlSigner {

    private static final String C14NEXC = "http://www.w3.org/2001/10/xml-exc-c14n#";

    private keyStoreInfo keyStoreInfo;
    private InputStream sourceXml;

    /**
     * Signs a specific XML using a private key via Java Key Store format
     *
     * More information:
     * https://gist.github.com/rponte/4039958
     * https://github.com/SUNET/eduid-mm-service/tree/master/src/main/java/se/gov/minameddelanden/common
     * https://stackoverflow.com/questions/5330049/java-equivalent-of-c-sharp-xml-signing-method
     */
    public SignedXml sign() throws NoSuchAlgorithmException, InvalidKeyException, KeyStoreException, SignatureException, IOException, InvalidAlgorithmParameterException, ParserConfigurationException, SAXException, MarshalException, XMLSignatureException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError, UnrecoverableEntryException {

        KeyStore keyStore = keyStoreInfo.getKeyStore();
        String alias = keyStoreInfo.getAlias();
        char[] password = keyStoreInfo.getPassword().toCharArray();

        // Create a DOM XMLSignatureFactory that will be used to
        // generate the enveloped signature.
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        // Create a Reference to the enveloped document (in this case,
        // you are signing the whole document, so a URI of "" signifies
        // that, and also specify the SHA1 digest algorithm and
        // the ENVELOPED Transform.
        Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null);
        Transform c14NEXCTransform = fac.newTransform(C14NEXC, (TransformParameterSpec) null);
        List<Transform> transforms = Arrays.asList(envelopedTransform, c14NEXCTransform);

        DigestMethod digestMethod = fac.newDigestMethod(DigestMethod.SHA1, null);
        Reference ref = fac.newReference("", digestMethod, transforms, null, null);

        // Create the SignedInfo.
        CanonicalizationMethod canonicalizationMethod = fac.newCanonicalizationMethod(CanonicalizationMethod.EXCLUSIVE, (C14NMethodParameterSpec) null);
        SignatureMethod signatureMethod = fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null);
        SignedInfo si = fac.newSignedInfo(canonicalizationMethod, signatureMethod, Collections.singletonList(ref));

        // Create the KeyInfo containing the X509Data.
        KeyInfoFactory keyInfoFactory = fac.getKeyInfoFactory();
        X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);

        X509Data newX509Data = keyInfoFactory.newX509Data(Arrays.asList(certificate));
        X509IssuerSerial issuer = keyInfoFactory.newX509IssuerSerial(certificate.getIssuerX500Principal().getName(), certificate.getSerialNumber());

        List<XMLStructure> data = Arrays.asList(newX509Data, issuer);
        KeyInfo keyInfo = keyInfoFactory.newKeyInfo(data);

        // Converts XML to Document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(sourceXml);

        // Create a DOMSignContext and specify the RSA PrivateKey and
        // location of the resulting XMLSignature's parent element.
        Key key = keyStore.getKey(alias, password);
        if (key == null) {
            throw new XmlSigningException("Private Key not found for alias '" + alias + "'");
        }

        DOMSignContext dsc = new DOMSignContext(key, doc.getDocumentElement());

        // Adds <Signature> tag before a specific tag inside XML - with or without namespace
		/*
		Node assertionTag = doc.getElementsByTagName("saml2:Assertion").item(0);
		Node afterTag = doc.getElementsByTagName("saml2:Subject").item(0);
		DOMSignContext dsc = new DOMSignContext(key, assertionTag, afterTag);
		dsc.setDefaultNamespacePrefix("ds");
		*/

        // Create the XMLSignature, but don't sign it yet.
        XMLSignature signature = fac.newXMLSignature(si, keyInfo);
        signature.sign(dsc); // Marshal, generate, and sign the enveloped signature.

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        TransformerFactory.newInstance()
                .newTransformer()
                .transform(new DOMSource(doc), new StreamResult(output));

        String rawSignedXml = new String(output.toByteArray());

        SignedXml xml = new SignedXml(rawSignedXml);
        return xml;
    }

    public XmlSigner withKeyStore(InputStream keyStore, String alias, String password) {

        if (keyStore == null)
            throw new XmlSigningException("KeyStore without private key");

        keyStoreInfo ksi = new keyStoreInfo(alias, password);
        ksi.load(keyStore);

        this.keyStoreInfo = ksi;
        return this;
    }

    public XmlSigner withXml(InputStream sourceXml) {

        if (sourceXml == null)
            throw new XmlSigningException("XML can not be null");

        this.sourceXml = sourceXml;
        return this;
    }

    public XmlSigner withXml(String sourceXml) {
        InputStream input = IOUtils.toInputStream(sourceXml, StandardCharsets.UTF_8);
        return withXml(input);
    }
}