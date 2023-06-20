package com.example.demo.operation_id;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class PaymentKeyGenerator {

    public static final String PATTERN_DATA = "yyyyMMddHHmmss";
    public static final String REGEX_REMOVE_FORMAT = "[^0-9]";
    public static final String EMPTY = "";

    public static void main(String[] args) {

        BigDecimal valuePayment = BigDecimal.valueOf(15.99);
        System.out.println(getKey(valuePayment));

    }

    public static String getKey(BigDecimal valuePayment) {

        if (Objects.isNull(valuePayment) || BigDecimal.ZERO.compareTo(valuePayment) == 0) {
            throw new IllegalArgumentException("O valor do pagamento não pode ser nulo ou igual a zero");
        }

        String formattedValuePayment = valuePayment.toPlainString().replaceAll(REGEX_REMOVE_FORMAT, EMPTY);

        LocalDateTime currentTimestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_DATA);
        String formattedTimestamp = currentTimestamp.format(formatter);

        UUID uuid = UUID.randomUUID();

        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(formattedTimestamp)
                .append(uuid.toString().replace("-", ""))
                .append(formattedValuePayment);

        return keyBuilder.toString();
    }

}
