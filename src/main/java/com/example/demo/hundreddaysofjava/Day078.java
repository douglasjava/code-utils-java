package com.example.demo.hundreddaysofjava;

import java.util.List;
import java.util.function.Function;

/**
 * Day 78 - Creating a generic Function.
 */
public class Day078 {

    public static void main(String[] args) {
        int input1 = 42;
        String output1 = map(input1, obj -> "The value is " + obj);
        System.out.println(output1);

        String[] input2 = {"a", "b", "c"};
        List<String> output2 = map(input2, List::of);
        System.out.println(output2);
    }

    private static <T, R> R map(T input, Function<T, R> function) {
        return function.apply(input);
    }
}