package org.digitalstack.concurrency;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        Thread th1 = new MyThread();
        th1.start();

        Runnable run1 = new MyRunnable(45);
        Thread th2 = new Thread(run1);
        th2.start();

        th2.interrupt();

        th2.join();

        System.out.println("Main");

        long start = System.currentTimeMillis();

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            s.append(">");
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
