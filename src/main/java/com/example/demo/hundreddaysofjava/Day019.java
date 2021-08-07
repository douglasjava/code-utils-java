package com.example.demo.hundreddaysofjava;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Day 19 - A Map implementation that keeps the elements in the same order that they were inserted.
 */
public class Day019 {

    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(5, "five");
        map.put(4, "four");
        map.put(3, "three");
        map.put(2, "two");
        map.put(1, "one");

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
