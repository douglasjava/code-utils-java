package com.example.demo.hundreddaysofjava;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Day 26 - Using Optional when null is a valid return value.
 */
public class Day026 {

    public static void main(String[] args) {
        // Instead of doing:
        String nullableValue = getNullableValue();
        if (nullableValue != null) {
            System.out.println(nullableValue.length());
        } else {
            System.out.println(0);
        }

        // Just do:
        System.out.println(getOptionalValue().map(String::length).orElse(0));
    }

    @Nonnull
    private static Optional<String> getOptionalValue() {
        return Optional.empty();
    }

    @Nullable
    private static String getNullableValue() {
        return null;
    }

}
