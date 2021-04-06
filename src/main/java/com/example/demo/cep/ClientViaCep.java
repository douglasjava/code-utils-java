package com.example.demo.cep;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class ClientViaCep {

	public static void main(String[] args) throws Exception {

		Cep cep = buscarEndereco("32141012");

		System.out.println(cep);
	}

	private static Cep buscarEndereco(String cep) throws Exception {

		Gson gson = new Gson();

		URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
		URLConnection urlConnection = url.openConnection();
		InputStream is = urlConnection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is)); 

		StringBuilder sb = new StringBuilder();

		br.lines().forEach(linha -> sb.append(linha.trim()));

		return gson.fromJson(sb.toString(), Cep.class);

	}

}
