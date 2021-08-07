package com.example.demo.hundreddaysofjava;

import java.io.IOException;
import java.util.Properties;

/**
 * Day 23 - Loading properties from a file.
 */
public class Day023 {

    public static void main(String[] args) throws IOException {
        var properties = new Properties();
        try (var reader = Day023.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(reader);
        }
        System.out.println(properties);
    }

}
