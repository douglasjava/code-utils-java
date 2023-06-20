package com.example.demo.operation_id;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PaymentKeyGeneratorTest {

    private static final String REGEX_REMOVE_FORMAT = "[^0-9]";
    private static final String PATTERN_DATA = "yyyyMMddHHmmss";
    private static final String EMPTY = "";
    private static final int LENGTH_DATE = 14;
    private static final int LENGTH_UUID = 32;


    @Test
    void testKeyLength() {
        var valuePayment = BigDecimal.valueOf(RandomUtils.nextLong(10, 9999));
        var key = PaymentKeyGenerator.getKey(valuePayment);
        var expected = LENGTH_DATE + LENGTH_UUID + valuePayment.toPlainString().replaceAll(REGEX_REMOVE_FORMAT, EMPTY).length();
        assertEquals(expected, key.length());
    }

    @Test
    void testHasValueAfterUUID() {
        BigDecimal valuePayment = BigDecimal.valueOf(RandomUtils.nextLong(10, 9999));
        String key = PaymentKeyGenerator.getKey(valuePayment);
        String valueAfterUUID = key.substring(LENGTH_DATE + LENGTH_UUID);
        assertFalse(valueAfterUUID.isEmpty());
    }

    @Test
    void testHasTimestampInBeginning() {
        BigDecimal valuePayment = BigDecimal.valueOf(RandomUtils.nextLong(10, 9999));
        String key = PaymentKeyGenerator.getKey(valuePayment);
        String timestamp = key.substring(0, LENGTH_DATE);
        assertDoesNotThrow(() -> LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern(PATTERN_DATA)));
    }

    @Test
    void testInvalidPaymentValue() {
        BigDecimal valuePayment = null;
        assertThrows(IllegalArgumentException.class, () -> PaymentKeyGenerator.getKey(valuePayment));
    }

    @Test
    void testZeroPaymentValue() {
        BigDecimal valuePayment = BigDecimal.ZERO;
        assertThrows(IllegalArgumentException.class, () -> PaymentKeyGenerator.getKey(valuePayment));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000.50", "500.00", "9999.99", "1234.567890"})
    void testKeyLength(BigDecimal value) {
        String key = PaymentKeyGenerator.getKey(value);
        int expectedLength = LENGTH_DATE + LENGTH_UUID + value.toPlainString().replaceAll(REGEX_REMOVE_FORMAT, EMPTY).length();
        Assertions.assertEquals(expectedLength, key.length());
    }

    @ParameterizedTest
    @MethodSource("provideParameterForValidateLengthHash")
    void testKeyLengthWithParameter(BigDecimal value) {
        String key = PaymentKeyGenerator.getKey(value);
        int expectedLength = LENGTH_DATE + LENGTH_UUID + value.toPlainString().replaceAll(REGEX_REMOVE_FORMAT, EMPTY).length();
        Assertions.assertEquals(expectedLength, key.length());
    }

    private static Stream<Arguments> provideParameterForValidateLengthHash() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(RandomUtils.nextLong(10, 9999))),
                Arguments.of(BigDecimal.valueOf(RandomUtils.nextLong(9999, 99999))),
                Arguments.of(BigDecimal.valueOf(RandomUtils.nextLong(60, 96))),
                Arguments.of(BigDecimal.valueOf(RandomUtils.nextLong(256, 520))),
                Arguments.of(BigDecimal.valueOf(RandomUtils.nextLong(1, 21))),
                Arguments.of(BigDecimal.valueOf(RandomUtils.nextLong(100000, 200000))),
                Arguments.of(BigDecimal.valueOf(RandomUtils.nextLong(650, 2500))),
                Arguments.of(BigDecimal.valueOf(RandomUtils.nextLong(781, 3000))),
                Arguments.of(BigDecimal.valueOf(RandomUtils.nextLong(99, 400)))
        );
    }

}
