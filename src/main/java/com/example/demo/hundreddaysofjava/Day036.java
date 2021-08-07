package com.example.demo.hundreddaysofjava;


import javax.annotation.Nonnull;

/**
 * Day 36 - Using javax.annotation.Nonnull (JSR 305) to avoid NullPointerException.
 */
public class Day036 {

    private Day036() {
    }

    public static void main(String[] args) {
        printLenght(null);
    }

    public static void printLenght(@Nonnull String s) {
        System.out.println(s.length());
    }

}
