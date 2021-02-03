package com.example.demo.qrcode;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

public class ConverteQrcode {

	// online
	// http://beautifytools.com/base64-to-image-converter.php

	// Certo:
	// iVBORw0KGgoAAAANSUhEUgAAAMgAAADIAQAAAACFI5MzAAADwElEQVR4Xu2XTa6kOgyFjTLIDDYQiW1kli3BBijYQLGlzLKNSGwAZhlE5T4mdW/rPakH5Sv1qFFJpeIr4eCfY5v4Txf9/8b39Y9oSSUaX54e7B7FDYlPMifhp5I8eHzZY/WZKM/xeNJxyU0lmaybQu49c+KXzxOZK7ofEctbOV6BunRc5fgh6a25kpvI9b7O6UcEviSbhzReTJMdn2H87Z3PCZGb038+03fkPia46hL4Kq5jGHFzgZE7dzSkTjTCAX0wKxmE/SpyR03IVwpmL7kn8wy1K3ng3N5HQ8jh1FvMfUDumI0NF9PsKMjMh1SG5SdqJaFQCMmoJfwKbvG19/mRxtUfzObiQ02uwiuNe6qLdXj7PtRHatFWEHjUDZH3QkPM5M1VaPIt2grCZ+A95QEpU8QIVGF5+0BB4FG3UCaLgOMvx16QOO4+tYLwlvBgvHcdmB4RLsmLCKGScHRdRJz5GY7VHjub1d95rSLI6MnnLsIUwm441S6pCb6hVePTyuO3hDo+Xu/IachiocQVkekDwg4prfijmiCdOcEOKng8LaQlT6FFW0OGgkKBEtOQoAcH4GJ/QKDHcURYzoBaGdExnlJ5OoLOI8HpPfLR4N4lxXdrlYZANWnmkQuhgV9RJJDeHtUQZPSczBZRLuMtyfnx1c0U5O45lSxfySCvueBnyx0FwY063KXWoTd6DBeS4Ld3NORFtED5GC1RsvuSxvtW2M8JpgDeIyRZUnuy4t3VNh9oSC8pQ1C+OaLmeIX4+RZtDVksBAaDmHmFfNdfnt+9UUH4RKPAQGchz+MGU2V8+uZRDbmgxAn5ctxF7ETjfVMxHaFeUvuAhfVW+rPltYbU6a6zDq71444hsTCGsts7GgK16yFRBQOd2fAGaEeh2VEQBOfYUXDoQpgFAqNQ1vDVfz4n0HU8GBl9Qj7jcaJK4lurPid1CTJ8LZg9GcdHzHHw5gMFQa+G5qGPIWXGk9C3YaT5QEPWcGyQq+gmxIche7l764GG7KKgaIkGdYwlYJOIcTuBgkjJhix20B4tDCJKzQcKUmexg50JAxS6IoY7rHctqzQEL/2Q7QH9ECVSMUlNbd7REJZoYMyMWDEx+4sPvhRWRzAbyiVOZVkFoKlvOx+Tew8OMirOkuBY7AiC2nygINjnZtkvITAYiu9pMekJdk10WlQGDK4B2gzxa6dWkgGTJtZWGZ2QOFD6bzsqIgJDHXTUiw9QLmryQLSL7NMddghyk6SSnqDgJPUgAxE9HHtJptC0SkH+dP0jf4/8AuirFqU2+IEgAAAAAElFTkSuQmCC

	public static void main(String[] args) throws IOException {
		System.out.println("Inicio");

		String envoCode1 = "00020101021226770014br.gov.bcb.pix2555pix.example.com/qr/9d36b84f-c70b-478f-b95c-12729b90ca255204000053039865406123.455802BR5925CIA ENERGETICA RIO G NORT6009SAO PAULO62070503***6304E910";

		String base64 = Base64.getEncoder().encodeToString(envoCode1.getBytes());

		System.out.println(envoCode1);
		System.out.println(base64);

		byte[] imageBytes = convertImage(base64);

		createImagem(imageBytes);

		System.out.println("Fim");
	}

	private static void createImagem(byte[] imageBytes) {
		String path = "D:\\imagem\\qrcode.jpg";
		File file = new File(path);

		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
			outputStream.write(imageBytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] convertImage(String base64) {
		String base64Image = base64.replaceAll(" ", "+");
		return Base64.getDecoder().decode(base64Image);
	}

}
