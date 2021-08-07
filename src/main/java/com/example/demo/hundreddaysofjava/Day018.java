package com.example.demo.hundreddaysofjava;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Day 18 - Finding the maximum value from a Collection.
 */
public class Day018 {

    public static void main(String[] args) {
        System.out.println(max(List.of(6, 3, 1, 8, 3, 9, 2, 7)));
    }

    private static Integer max(Collection<Integer> collection) {
        return collection.stream()
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

}
