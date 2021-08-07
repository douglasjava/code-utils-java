package com.example.demo.hundreddaysofjava.day075;

class PaymentProcessorImpl implements PaymentProcessor {

    private final DependencyA dependencyA;
    private final DependencyB dependencyB;
    private final DependencyC dependencyC;

    PaymentProcessorImpl(DependencyA dependencyA, DependencyB dependencyB, DependencyC dependencyC) {
        this.dependencyA = dependencyA;
        this.dependencyB = dependencyB;
        this.dependencyC = dependencyC;
    }

    @Override
    public void process(Payment payment) {
        dependencyA.process();
        dependencyB.process();
        dependencyC.process();

        System.out.println("Finishing payment...");
    }
}