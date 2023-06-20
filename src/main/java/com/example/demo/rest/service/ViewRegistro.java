package com.example.demo.rest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.rest.service.dto.RegistroDiarioDTO;
import com.example.demo.rest.service.dto.Registros;
import com.example.demo.rest.service.dto.RespostaErro;
import com.google.gson.Gson;

public class ViewRegistro {

	public static void main(String[] args) {
		call();
	}

	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void call() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "aaf579f63f0fc87b82f3414c3f7140f51d4dcf6d");

		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<Registros> registros;
		try {
			registros = getRestTemplate().exchange(
					"http://mrc-e-mg.montreal.com.br:9993/registros-mrc-mg/2020-03-31/2020-04-30", HttpMethod.GET, entity,
					Registros.class);
			
			System.out.println(String.format("%d Registros foram encontrados", getQuantidadeRegistros(registros.getBody())));
			
		} catch (HttpClientErrorException e) {		
			 ResponseEntity<String> teste = ResponseEntity
					 .status(e.getRawStatusCode())
					 .headers(e.getResponseHeaders())
					 .body(e.getResponseBodyAsString());
			 
			 System.out.println(jsonToObject(teste.getBody(), RespostaErro.class));
		}


	}
	
	private static <T> Object jsonToObject(String inputString, Class<T> T) {
		return new Gson().fromJson(inputString, T);
	}

	private static int getQuantidadeRegistros(List<RegistroDiarioDTO> listaRegistroDiario) {
		return listaRegistroDiario.stream().mapToInt(RegistroDiarioDTO::getQtItens).reduce(0, Integer::sum);
	}

}
