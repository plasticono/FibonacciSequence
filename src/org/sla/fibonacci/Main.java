package org.sla.fibonacci;

public class Main {

    public static void main(String[] args) {
        Runner runner = new Runner(50, 0, 1);
        Runner runner1 = new Runner(1 , 10, 11);

        Thread thread1 = new Thread(runner);
        //thread1.setPriority(1);
        thread1.start();

        Thread thread2 = new Thread(runner1);
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
