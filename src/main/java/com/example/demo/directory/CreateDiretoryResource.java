package com.example.demo.directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;

public class CreateDiretoryResource {

	@Value("${dir.upload.files}")
	private static String diretorioFileUpload;

	public static void main(String[] args) {
		
		System.out.println(diretorioFileUpload);

		String dir = "src/main/resources/upload_files";

		Path root = Paths.get(dir);

		createDirectoriesNIO(root);

	}

	public static void createDirectoriesNIO(Path path) {

		try {

			Files.createDirectories(path);
			System.out.println("Directory is created!");

		} catch (IOException e) {
			System.err.println("Failed to create directory!" + e.getMessage());
		}

	}

}
