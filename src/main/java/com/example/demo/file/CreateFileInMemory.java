package com.example.demo.file;

import static com.opencsv.ICSVWriter.DEFAULT_ESCAPE_CHARACTER;
import static com.opencsv.ICSVWriter.DEFAULT_LINE_END;
import static com.opencsv.ICSVWriter.NO_QUOTE_CHARACTER;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVWriter;

public class CreateFileInMemory {

	public static void main(String[] args) {

		StringBuilder output = new StringBuilder("texto;texto;texto;texto");

		readMemory(output);
		
		readMemoryOpeanCsv(output);

	}

	private static void readMemoryOpeanCsv(StringBuilder output) {

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(baos);
				CSVWriter writer = new CSVWriter(osw, ';', NO_QUOTE_CHARACTER, DEFAULT_ESCAPE_CHARACTER,
						DEFAULT_LINE_END)) {

			writer.writeNext(getCabecalhos());
			writer.writeAll(getBody());

			baos.flush();
			osw.flush();

			try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray())) {
				System.out.println(bais);
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	private static List<String[]> getBody() {
		return List.of("Douglas", "29").stream().map(t -> new String[] { "Douglas", "29" })
				.collect(Collectors.toList());
	}

	private static String[] getCabecalhos() {
		return new String[] { "nome", "idade" };
	}

	private static void readMemory(StringBuilder output) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

			// Convertendo Texto para bytes
			byte[] bytesFile = output.toString().getBytes();

			// Escrevendo no stream
			baos.write(bytesFile);

			// Lendo....
			String streamData = baos.toString();
			System.out.println("Output stream: " + streamData);

			// byte[] -> InputStream
			try (ByteArrayInputStream inStream = new ByteArrayInputStream(baos.toByteArray())) {
				System.out.println(inStream);
			}
			;

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
