package org.sla.fibonacci;

public interface Fibonacci extends Runnable {
    // Fields
    int amountofNumbersInSequence = 0;
    int number1 = 0;
    int number2 = 0;

    // Methods


    @Override
    void run();
}