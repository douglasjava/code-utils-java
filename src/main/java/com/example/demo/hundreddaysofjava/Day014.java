package com.example.demo.hundreddaysofjava;

import java.math.BigDecimal;

/**
 * Day 14 - Never pass a double as argument when constructing BigDecimal objects.
 */
public class Day014 {

    public static void main(String[] args) {
        // Prints 1.229999999999999982236431605997495353221893310546875
        System.out.println(new BigDecimal(1.23)); //incorrect

        // Prints 1.23
        System.out.println(new BigDecimal("1.23"));

        // Prints 1.23
        System.out.println(BigDecimal.valueOf(1.23));
    }

}
