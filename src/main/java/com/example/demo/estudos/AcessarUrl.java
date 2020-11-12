package com.example.demo.estudos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class AcessarUrl {

	public static void main(String[] args) throws Exception {
		System.out.println(invocarUrlLogout(
				"https://fs.montreal.com.br/adfs/ls/idpinitiatedsignon?client-request-id=c74b3ce7-812c-4a72-a801-0080010000ef"));
	}

	public static String invocarUrlLogout(String adfsUrlLogout) throws Exception {
		URL url = new URL(adfsUrlLogout);

		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			String resposta = connection.getResponseMessage();

			System.out.println(resposta);
			InputStream inputStream = connection.getInputStream();

			String text = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
					.collect(Collectors.joining("\n"));

			if (!resposta.equalsIgnoreCase("OK") || !text.contains("Voc&#234; saiu com &#234;xito.")) {
				throw new Exception("Erro no logout");
			}

		} finally {
			if (connection != null)
				connection.disconnect();
		}
		return "Logout efetuado com sucesso";
	}

}
