package com.example.demo.rest.service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Services {

	public static void main(String[] args) {
		call();
	}

	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void call() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("user", "douglgdgdggdas");

		HttpEntity<?> entity = new HttpEntity<Object>(body, headers);

		String teste1 = getRestTemplate().postForEntity("http://localhost:8068/teste/authenticate", entity, String.class).getBody();

		String teste2 = getRestTemplate().exchange("http://localhost:8068/teste/authenticate", HttpMethod.POST, entity, String.class).getBody();

		System.out.println(teste1);
		System.out.println(teste2);
	}

}
