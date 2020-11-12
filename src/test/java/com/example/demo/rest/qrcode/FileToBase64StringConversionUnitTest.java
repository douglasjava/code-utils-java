package com.example.demo.rest.qrcode;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class FileToBase64StringConversionUnitTest {

	private String inputFilePath = "test_image.jpg";
	private String outputFilePath = "test_image_copy.jpg";

	@Test
	public void fileToBase64StringConversion() throws IOException {
		
		// load file from /src/test/resources
		ClassLoader classLoader = getClass().getClassLoader();
		File inputFile = new File(classLoader.getResource(inputFilePath).getFile());

		byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
		String encodedString = Base64.getEncoder().encodeToString(fileContent);

		// create output file
		File outputFile = new File(inputFile.getParentFile().getAbsolutePath() + File.pathSeparator + outputFilePath);

		// decode the string and write to file
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		FileUtils.writeByteArrayToFile(outputFile, decodedBytes);

		assertTrue(FileUtils.contentEquals(inputFile, outputFile));
	}

	@Test
	public void fileToBase64StringConversionWithBase64() throws IOException {
		
		// load file from /src/test/resources
		ClassLoader classLoader = getClass().getClassLoader();
		File inputFile = new File(classLoader.getResource(inputFilePath).getFile());

		byte[] fileContent = FileUtils.readFileToByteArray(inputFile);		
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		String base64 = "iVBORw0KGgoAAAANSUhEUgAAAMgAAADIAQAAAACFI5MzAAADqElEQVR4Xu2XTY6kMAyFjbJgV1wAKddglyvBBfi5QHGl7HKNSFyA2mUR4XlOqro1I80CtzSrQb2o5kPE2C/PDvHfLvrzxtf1n2hJJrKbpyb0S+q7kEcyJ9GiJQtb5mMdIlGcvHm2x0tuKsnY9lOgyVsOcR4i1nn5/idkdMz+uJzdAhY5fkg6b/bQj0SPgV/hR2ThvgmxS/xie7b2Odjv7NwnRMjBb3/jV+VuE1x5buXdDdunw+2PdjQEYrEnIdhjpX5GqZPcUZPFY4Vj5zgjoy43KXYca3YUpAv2anMTcJvPwZzOcDJlHQ0ZhwMhI/Dd0+xQK4IYtYQ59A9nkMsHlOiPjc3Oxw8II+oOuoYkQxwdvuNd7fskdwxd8554S7GBwBONQ622gvA18B7ixOZyUh+4wlyrrSGodlWf2RIeOfaE22rC1aXmoX8MtHh+pTi7mh0FET9YvH22/HQG7rKzWV2NQEHwYqThuCguoYd2lgBVVu2oSDCr7GB5fdHOcQ3FXVQEps4eseeHk47RhPxoa9QKUnQXwOOD+JQ6Q4yf3XibQIMRprISdbKJsflgXWoi60zBYqudzu4ByYB8yp7TENQHXpVn2B5BPscrIJ3Fq1QEXXoqQibpithzmd651hBG53dmpQwutyGi2s1U5Cqddm0hIioej5RwWUdDsE7HWIQaRqc9tpQh8E8E94nH1/ddbUSteYWe2reP3id4axR3CXl2SIZkd+Oyjop0DA3C12Xk2SBwmN/w7mYKMkoriyR5xQ2sCU+tUSsIBpN+8tgZNIofoODo4dUTNeQaYgPDExgfbfH4oSpRQyCWUbaIWQe7EnQNNakJinwwprmEiRitGz/k2ZrR+4Q3mAoMHp0fhurg8f0nagXJk0cCsEvEjKU3wrdc1Y6CIEZMJRZjzgsWFcwJg/f8zs59colYIo4RU0J9+JTA39W+T3KHXHKP08nTycBYTLTmQEF4JRi8+Ch03cm/5cSjJZwsUjg7s0v3tnCX7p0DDVllbiUasE45MKE3fqaN+yRPCaNE7OQwIQPsnr61oyBUVDM6JLK0CzrOuoM1RD53hl6gGjJXC2nLszU7KpIbjxLFRmZhjNt4Kr/XuU0QptjA1UY5LTn86OXcqSWQ4ZKklU3Sf9DDMbDoSZkTZcqWwzoy4fCjRq0kjVQJwpGvF6f/XkdDxGAw8iR4PA7EmP31ZEEzTCgyDl5oaHgQo5mekAxNMHjZahfBlSOJKnXkb9d/8u/IL1ppPpWg3G7xAAAAAElFTkSuQmCC";

		// create output file
		File outputFile = new File(inputFile.getParentFile().getAbsolutePath() + File.pathSeparator + outputFilePath);

		// decode the string and write to file
		byte[] decodedBytes = Base64.getDecoder().decode(base64);
		FileUtils.writeByteArrayToFile(outputFile, decodedBytes);

		assertTrue(FileUtils.contentEquals(inputFile, outputFile));
	}
	
}
