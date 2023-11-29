package org.digitalstack.concurrency;

import lombok.SneakyThrows;

public class MyRunnable implements Runnable{

    int target;

    public MyRunnable(int target) {
        this.target = target;
    }

    @Override
    public void run() {
        System.out.println("I am a Runnable");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Oh, no!");
            throw new RuntimeException(e);
        }

        System.out.println("I am the same Runnable");
    }
}
