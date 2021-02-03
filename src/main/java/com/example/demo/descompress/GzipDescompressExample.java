package com.example.demo.descompress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

public class GzipDescompressExample {

	public static void main(String[] args) {

        Path source = Paths.get("/home/mkyong/test/sitemap.xml.gz");
        Path target = Paths.get("/home/mkyong/test/sitemap.xml");

        if (Files.notExists(source)) {
            System.err.printf("The path %s doesn't exist!", source);
            return;
        }

        try {

            decompressGzip(source, target);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	 public static void decompressGzip(Path source, Path target) throws IOException {

	        try (GZIPInputStream gis = new GZIPInputStream(new FileInputStream(source.toFile()));
	             FileOutputStream fos = new FileOutputStream(target.toFile())) {

	            // copy GZIPInputStream to FileOutputStream
	            byte[] buffer = new byte[1024];
	            int len;
	            while ((len = gis.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	            }

	        }

	    }
	
}
