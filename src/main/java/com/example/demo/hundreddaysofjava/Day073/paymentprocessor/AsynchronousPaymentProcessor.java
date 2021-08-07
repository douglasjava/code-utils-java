package com.example.demo.hundreddaysofjava.Day073.paymentprocessor;

@Asynchronous
class AsynchronousPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(Payment payment) {
        System.out.println("Processing payment " + payment + " asynchronously");
    }
}
