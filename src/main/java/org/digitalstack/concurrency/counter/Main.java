package org.digitalstack.concurrency.counter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Counter counter = new PrimitiveCounter();

        List<Runnable> runnables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            runnables.add(new CounterRunnable(counter));
        }

        List<Thread> threads = new ArrayList<>();
        runnables.forEach(runnable -> threads.add(new Thread(runnable)));

        long start = System.currentTimeMillis();

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        long end = System.currentTimeMillis();

        System.out.println((end - start) + " : " + counter.getValue());
    }
}
