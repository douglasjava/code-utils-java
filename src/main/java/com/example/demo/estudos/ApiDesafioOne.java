package com.example.demo.estudos;

import org.springframework.web.client.RestTemplate;

public class ApiDesafioOne {

	public static void main(String[] args) {
		System.out.println(call(2014, "Chelsea"));

	}

	private static int call(int year, String team) {
		Integer sumInteger = 0;
		ApiDesafioDTO apiDesafioDTO = null;
		
		String url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team1=" + team + "&page=1";				
		Integer total1 = getRestTemplate().getForEntity(url, ApiDesafioDTO.class).getBody().getTotal_pages();
		
		for (int i = 0; i < total1; i++) {
			url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team1=" + team + "&page="+i;
			apiDesafioDTO = getRestTemplate().getForEntity(url, ApiDesafioDTO.class).getBody();
			sumInteger += apiDesafioDTO.getData()
					.stream()
					.mapToInt(Data -> Data.getTeam1goals())
					.reduce(0,Integer::sum);
		}
		
		url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team2=" + team + "&page=1";		
		Integer total2 = getRestTemplate().getForEntity(url, ApiDesafioDTO.class).getBody().getTotal_pages();
		
		for (int i = 0; i < total2; i++) {
			url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team2=" + team + "&page="+i;
			apiDesafioDTO = getRestTemplate().getForEntity(url, ApiDesafioDTO.class).getBody();
			sumInteger += apiDesafioDTO.getData()
					.stream()
					.mapToInt(Data -> Data.getTeam2goals())
					.reduce(0, Integer::sum);
		}

		return sumInteger;

	}

	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
