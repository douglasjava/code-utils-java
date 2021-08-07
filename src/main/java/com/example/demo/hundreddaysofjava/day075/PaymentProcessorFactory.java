package com.example.demo.hundreddaysofjava.day075;

import jakarta.enterprise.inject.Produces;

final class PaymentProcessorFactory {

    private PaymentProcessorFactory() {
    }

    @Produces
    static PaymentProcessor createPaymentProcessor() {
        return new PaymentProcessorImpl(new DependencyA(), new DependencyB(), new DependencyC());
    }
}