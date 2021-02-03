package com.example.demo.qrcode;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GerarBase64String {

	public static void main(String[] args) throws WriterException, IOException {
		System.out.println("Inicio");

		String envoCode1 = "00020101021226770014br.gov.bcb.pix2555pix.example.com/qr/9d36b84f-c70b-478f-b95c-12729b90ca255204000053039865406123.455802BR5925CIA ENERGETICA RIO G NORT6009SAO PAULO62070503***6304E910";

		QRCodeWriter barcodeWriter = new QRCodeWriter();

		BitMatrix bitMatrix = barcodeWriter.encode(envoCode1, BarcodeFormat.QR_CODE, 200, 200);

		BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "jpg", baos);
		baos.flush();

		byte[] imageInByte = baos.toByteArray();

		String encodedString = Base64.getEncoder().encodeToString(imageInByte);

		System.out.println("BASE64 ->" + encodedString);

		System.out.println("ENV ->" + envoCode1);
		
		System.out.println("Gerando imagem...."); 
		
		byte[] imageBytes = convertImage(encodedString);

		createImagem(imageBytes);

		System.out.println("Fim");

	}
	
	public static byte[] convertImage(String base64) {
		String base64Image = base64.replaceAll(" ", "+");
		return Base64.getDecoder().decode(base64Image);
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

}
