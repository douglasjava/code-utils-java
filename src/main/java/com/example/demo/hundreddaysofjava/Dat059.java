package com.example.demo.hundreddaysofjava;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Day 59 - Using a Predicate.
 */
public class Dat059 {

    public static void main(String[] args) {
        /*
         A Predicate<T> is the same as Function<T, Boolean>.
         It consumes a T and returns a Boolean.
         */
        Predicate<Integer> isPair = intValue -> intValue % 2 == 0;

        List<Integer> numbers = getNumbers();
        numbers.stream()
                .filter(isPair)
                .forEach(System.out::println);
    }

    private static List<Integer> getNumbers() {
        return IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
    }


}
