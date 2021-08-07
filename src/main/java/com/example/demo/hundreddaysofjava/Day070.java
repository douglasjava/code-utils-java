package com.example.demo.hundreddaysofjava;

import java.time.LocalDate;

/**
 * Day 70 - Creating Parameterized Tests With JUnit.
 */
public class Day070 {

    //teste

    record Person(String name, LocalDate dateOfBirth) {

        public int isYearsHigherThan(int year) {
            return 0;
        }

    }
}
