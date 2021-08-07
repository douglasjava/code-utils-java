package com.example.demo.hundreddaysofjava;

import java.security.SecureRandom;

/**
 * Day 32 - Using switch to return a value.
 */
public class Day032 {

    public static void main(String[] args) {
        String result = map(randomNumber());
        System.out.println(result);
    }

    private static String map(int number) {
        // Requires JDK 12
        return switch (number) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            default -> "unknown";
        };
    }

    private static int randomNumber() {
        return new SecureRandom().nextInt(4);
    }

}
