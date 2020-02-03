package org.sla.fibonacci;

public class Runner implements Fibonacci {

    private int firstNumber, secondNumber, tempNumber;
    private int length;
    private static int startLength;

    private boolean running;

    String sequence;

    public Runner(int amount, int first, int second) {
        running = true;
        this.length = amount;
        this.firstNumber = first;
        this.secondNumber = second;
        this.startLength = amount;
        sequence = firstNumber + " " + secondNumber;
    }

    @Override
    public void run() {
        try {
            calculate(firstNumber, secondNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void calculate(int first, int second) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": calculating");
        if (running) {
            tempNumber = first + second;
            firstNumber = secondNumber;
            secondNumber = tempNumber;
            sequence = sequence + " " + tempNumber;
            length--;
            if (length > 2) {
                calculate(firstNumber, secondNumber);
            } else {
                running = false;
                calculate(firstNumber, secondNumber);
            }
        } else {
            for (int i = 0; i < startLength; i++) {
                String[] strings = sequence.split(" ");
                //print(strings[i]);
            }
            print();
            // System.out.println(Thread.currentThread().getName() + ": "  + sequence);

        }
    }

    synchronized void print() throws InterruptedException {
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName() + " " + sequence);
        /*for (int i = 0; i < startLength; i++) {
            String[] strings = sequence.split(" ");
            System.out.print(strings[i] + " ");
            Thread.sleep(100);
        }
        System.out.println("");*/
    }


}
