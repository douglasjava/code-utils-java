package com.example.demo.hundreddaysofjava;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day070Test {

    private static Stream<Arguments> isYearsHigherThanSource() {
        Day070.Person peter = new Day070.Person("Peter", LocalDate.of(1950, 1, 1));
        Day070.Person john = new Day070.Person("John", LocalDate.of(2015, 1, 1));
        Day070.Person mary = new Day070.Person("Mary", LocalDate.of(2003, 1, 1));

        return Stream.of(
                Arguments.of(peter, 18, true),
                Arguments.of(john, 18, false),
                Arguments.of(mary, 18, true)
        );
    }

    @ParameterizedTest
    @MethodSource("isYearsHigherThanSource")
    void isYearsHigherThan(Day070.Person person, int years, boolean expectedResult) {
        assertThat(person.isYearsHigherThan(years))
                .isEqualTo(expectedResult);
    }

}
