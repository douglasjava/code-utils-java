package com.example.demo.hundreddaysofjava;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

/**
 * Day 17 - Splitting Strings.
 */
public class Day017 {

    private static final Pattern REGEX = Pattern.compile(", ");

    public static void main(String[] args) {
        LocalDateTime dateStart = LocalDateTime.now();
        System.out.println("Simple split: ");
        for (String column : simpleSplit()) {
            System.out.println(column);
        }

        System.out.println("TIME simpleSplit: " + dateStart.until(LocalDateTime.now(), ChronoUnit.NANOS) + "ns");

        dateStart = LocalDateTime.now();
        System.out.println("Performant split: ");
        for (String column : performantSplit()) {
            System.out.println(column);
        }

        System.out.println("TIME performantSplit: " + dateStart.until(LocalDateTime.now(), ChronoUnit.NANOS) + "ns");
    }

    private static String[] simpleSplit() {
        return "id, name, country, gender".split(", ");
    }

    // If you will split frequently, prefer this implementation.
    private static String[] performantSplit() {
        return REGEX.split("id, name, country, gender");
    }

}
