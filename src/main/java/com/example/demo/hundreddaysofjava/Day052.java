package com.example.demo.hundreddaysofjava;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Day 52 - Making IOException unchecked.
 */
public class Day052 {

    public static void main(String[] args) {
        System.out.println(readFile());
    }

    public static String readFile() {
        try {
            return Files.readString(Path.of("/test.txt"));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
