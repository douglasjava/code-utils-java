package com.example.demo.hundreddaysofjava.Day073.paymentprocessor;

import java.math.BigDecimal;

public final record Payment(String id, BigDecimal value) {
}