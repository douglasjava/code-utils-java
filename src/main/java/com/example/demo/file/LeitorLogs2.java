package com.example.demo.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class LeitorLogs2 {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		String fileName = "D:\\Douglas\\Cursos\\MBA\\PA\\logs-REST-ms-pagamento-ms-cliente.txt";

		List<Integer> listTempo = new ArrayList<>();

		System.out.println("Iniciou.....");

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(":");

				if (line.contains("Fim scheduler Tempo Gasto:")) {
					String tempo = arr[arr.length - 1].replace(" Milisegundos", "").trim();
					listTempo.add(Integer.parseInt(tempo));
					// System.out.println(line);
				}

			}

			IntSummaryStatistics status = listTempo.stream().collect(Collectors.summarizingInt(n -> n.intValue()));

			System.out.println("Qtde: " + status.getCount());
			System.out.println("Média: " + status.getAverage());
			System.out.println("Maxima: " + status.getMax());
			System.out.println("Minima: " + status.getMin());

			System.out.println("Finalizou.....");

		}

	}
	
}
