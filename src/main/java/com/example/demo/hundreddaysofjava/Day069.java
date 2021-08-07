package com.example.demo.hundreddaysofjava;

import java.security.SecureRandom;
import java.util.stream.Stream;

/**
 * Day 69 - Generating an infinite Stream.
 */
public class Day069 {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static void main(String[] args) {
        Stream.generate(() -> SECURE_RANDOM.nextInt(99) + 1)
                .forEach(System.out::println);
    }

}
