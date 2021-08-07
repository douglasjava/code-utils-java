package com.example.demo.hundreddaysofjava;

/**
 * Day 20 - Reversing a String
 */
public class Day020 {

    public static void main(String[] args) {
        var original = "moc.ipataergeht";
        var reversed = new StringBuilder(original).reverse().toString();
        System.out.println(reversed);
    }

}
