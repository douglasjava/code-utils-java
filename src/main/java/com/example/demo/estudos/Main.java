package com.example.demo.estudos;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Account account = new Account();

        System.out.println("Balance before the transaction:" + account.getBalance());

        teste(TransactionType.BUY, account, BigDecimal.valueOf(500));

    }


    public static void teste(TransactionType transactionType, Account account, BigDecimal cashValue) {
        transactionType.doTransactionOperation(account, cashValue);
        System.out.println("Balance after the transaction:" + account.getBalance());
    }


}
