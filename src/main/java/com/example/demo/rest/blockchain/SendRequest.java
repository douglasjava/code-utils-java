package com.example.demo.rest.blockchain;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;


public class SendRequest {

    public static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        try {

            URI uri = new URI("https://192.168.18.241:7054/api/v1/enroll");
            var hosts = List.of("hosts");
            var certificateRequest = "-----BEGIN CERTIFICATE REQUEST-----\r\nMIHKMHICAQAwEDEOMAwGA1UEAxMFYWRtaW4wWTATBgcqhkjOPQIBBggqhkjOPQMB\r\nBwNCAATsWz5FsOKZLp/qKurppNBE4AcnGF/ax8WRVr1YGpiW0LrDpH78p3btcA8l\r\nG20SwGqukQFHy9VJxprGGcvnJKiRoAAwCgYIKoZIzj0EAwIDSAAwRQIgHuSTTGAh\r\nlp59f5i+lIckh0oWUdKmtVsG4JTjoqabL3wCIQDX4dpgpAaJdYUS0IXRpDXGxbUc\r\n4GZcK08l0WdUnq6U2A==\r\n-----END CERTIFICATE REQUEST-----\r\n";
            var enrollRequest = Enroll.builder().profile("tls").hosts(hosts).certificate_request(certificateRequest).build();

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Basic YWRtaW46YWRtaW5wdw==");

            HttpEntity<Enroll> httpEntity = new HttpEntity<>(enrollRequest, headers);

            ResponseEntity<String> response = getRestTemplate().postForEntity(uri, httpEntity, String.class);

            System.out.println(response.getBody());


        } catch (HttpClientErrorException e) {
            ResponseEntity<String> teste = ResponseEntity
                    .status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());

            System.out.println(teste);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }



    }

    private static HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

}
