package com.example.demo.hundreddaysofjava.Day073.paymentprocessor;

@Synchronous
class SynchronousPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(Payment payment) {
        System.out.println("Processing payment " + payment + " synchronously");
    }
}