package com.example.demo.estudos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum TransactionType {

    BUY {
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue) {
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.15), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }
    },
    SELL {
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue) {
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.1), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }
    },
    DEPOSIT {
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue) {
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.05), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }
    },
    WITHDRAWALL {
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue) {
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.20), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }
    };

    public abstract void doTransactionOperation(Account account, BigDecimal cashValue);

    BigDecimal calculateTax(BigDecimal percentage, BigDecimal cashValue) {
        return cashValue
                .multiply(percentage)
                .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
    }


}
