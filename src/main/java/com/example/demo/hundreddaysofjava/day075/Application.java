package com.example.demo.hundreddaysofjava.day075;

import jakarta.inject.Inject;

class Application {

    private final PaymentProcessor paymentProcessor;

    @Inject
    private Application(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void run() {
        paymentProcessor.process(new Payment());
    }
}
