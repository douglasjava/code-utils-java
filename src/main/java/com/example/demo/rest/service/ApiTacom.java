package com.example.demo.rest.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.rest.service.dto.RetornoErroTacom;
import com.example.demo.rest.service.dto.RetornoTacom;
import com.google.gson.Gson;

public class ApiTacom {



	private final static String token = "Bearer eyJraWQiOiJIZVkzTmVqTlZIM3RRSGVaWGhxNVJmcklDeXpJcUNrbFhwbFgrTFFYN05FPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI3anE0Y2Rvajl0b2k1N2toZGFuMnV1MTV0aSIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiY2FyYWRocmFzXC9jYXJkcyBjYXJhZGhyYXNcL3JlYWQgY2FyYWRocmFzXC90cmFuc3BvcnRjYXJkcyBjYXJhZGhyYXNcL3dyaXRlIGNhcmFkaHJhc1wvYmFua3RyYW5zZmVycyBjYXJhZGhyYXNcL3RhcmlmZiBjYXJhZGhyYXNcL2tub3d5b3VyY2xpZW50IGNhcmFkaHJhc1wvcGF5bWVudHMgY2FyYWRocmFzXC9yZWNoYXJnZXMgY2FyYWRocmFzXC9zcGxpdCBjYXJhZGhyYXNcL2JpbGxldCBjYXJhZGhyYXNcL2luZGl2aWR1YWxzUG9zdCBjYXJhZGhyYXNcL2xvY2stZnVuZHMgY2FyYWRocmFzXC93ZWJob29rIGNhcmFkaHJhc1wvZG9jLXNweSBjYXJhZGhyYXNcL2NhcnRvZXMgY2FyYWRocmFzXC9jcnlwdCBjYXJhZGhyYXNcL3AycHRyYW5zZmVyIGNhcmFkaHJhc1wvb21uaWNoYW5uZWwiLCJhdXRoX3RpbWUiOjE1OTI1OTMyNzYsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX2pqT1lDVDQ4MSIsImV4cCI6MTU5MjU5Njg3NiwiaWF0IjoxNTkyNTkzMjc2LCJ2ZXJzaW9uIjoyLCJqdGkiOiI2YzE0M2EzZi1mMDgwLTQ0Y2ItYTliNi1jNWUxOGRmNGEwOWIiLCJjbGllbnRfaWQiOiI3anE0Y2Rvajl0b2k1N2toZGFuMnV1MTV0aSJ9.dhCzFsWcdEbvWiARPyqETIAIGj537w7bF_bH37E_Hm-sZlNG43_RgzihV8c16GwAuMBvzmAOLMLH5tijUnhCig479FjliX3wXxz7znsLd7YsQ55L37l-VaA-MHdMyk8MsEbuQDDu5D_Z2eeklFBV9tJ4h1wd1drKKQqt9Wq5ahj5LkpiUXdIrTz9pJpCGHZFDQAkl8uBzNdpqtDByO2kuGpnkC1cYFAACkLzB7N1Y55qnJIGXdICKjGit_fPZuzvdoaFnt8jtaRvgseM7kS6cRz_WumP9Xom35lhmebeC_9XTGh0IKETLZEw_YVq8H1cv06GozfUzeBDPYPu-SUBCg";
	private final static String url = "https://api.caradhras.io/v2/individuals/589f9008-6d13-47db-8227-75e901ff6c1b/documents?category=DRIVER_LICENSE_VERSE";

	public static void main(String[] args) throws IOException {
		call();
	}

	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void call() throws IOException {		

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.set("Authorization", token);
		
		InputStream inputStream = new ClassPathResource("imagem-tacom.jpg").getInputStream();
		byte[] file = IOUtils.toByteArray(inputStream);
		HttpEntity<byte[]> requestEntity = new HttpEntity<>(file, headers);

		ResponseEntity<RetornoTacom> registros;
		try {

			registros = getRestTemplate().exchange(url, HttpMethod.POST, requestEntity, RetornoTacom.class);

			System.out.println(String.format("%d Registros foram encontrados", registros.getBody()));

		} catch (HttpClientErrorException e) {
			ResponseEntity<String> teste = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());

			System.out.println(jsonToObject(teste.getBody(), RetornoErroTacom.class));
		}

	}

	private static <T> Object jsonToObject(String inputString, Class<T> T) {
		return new Gson().fromJson(inputString, T);
	}


	
}
