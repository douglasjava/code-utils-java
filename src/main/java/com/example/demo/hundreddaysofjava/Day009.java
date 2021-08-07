package com.example.demo.hundreddaysofjava;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Day 9 - Creating a valued Enum.
 */
public class Day009 {

    public static void main(String[] args) {
        for (Gender gender : Gender.values()) {
            System.out.printf("The value of %s is %s%n", gender, gender.getValue());
        }
    }

    @AllArgsConstructor
    @Getter
    public enum Gender {
        FEMALE('f'),
        MALE('m');

        private final char value;

    }
}
