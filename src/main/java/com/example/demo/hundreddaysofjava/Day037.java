package com.example.demo.hundreddaysofjava;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Day 37 - Using Objects.requireNonNullElse when Optional is not an option.
 */
public class Day037 {

    public static void main(String[] args) {
        String s = Objects.requireNonNullElse(doStuff(), "not found");

        // Will print 'not found'
        System.out.println(s);
    }

    @Nullable
    private static String doStuff() {
        return null;
    }

}
