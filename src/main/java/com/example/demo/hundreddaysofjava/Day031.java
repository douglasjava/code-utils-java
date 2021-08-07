package com.example.demo.hundreddaysofjava;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Day 31 - Converting a Stream to List on JDK 16.
 */
public class Day031 {

    public static void main(String[] args) {
        // Instead of doing:
        List<String> list = Stream.of("the", "great", "api", ".com").collect(Collectors.toList());

        // Just do:
        List<String> listJdk16 = Stream.of("the", "great", "api", ".com").toList();
    }

}
