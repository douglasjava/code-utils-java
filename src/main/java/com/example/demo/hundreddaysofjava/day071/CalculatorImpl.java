package com.example.demo.hundreddaysofjava.day071;

class CalculatorImpl implements Calculator {

    private CalculatorImpl() {
    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
