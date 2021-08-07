package com.example.demo.hundreddaysofjava;

import java.time.LocalTime;
import java.util.Optional;

/**
 * Day 33 - Start using Optional#orElseThrow instead of Optional#get.
 */
public class Day033 {

    public static void main(String[] args) {
        Optional<LocalTime> optionalValue = getOptionalValue();

        // Stop using Optional#get.
        // It will be deprecated soon, as you can see in https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8160606
        System.out.println(optionalValue.get());

        // Start using Optional#orElseThrow instead of Optional#get
        System.out.println(getOptionalValue().orElseThrow());
    }

    private static Optional<LocalTime> getOptionalValue() {
        return Optional.of(LocalTime.now());
    }

}
