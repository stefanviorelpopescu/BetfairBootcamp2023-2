package org.digitalstack.concurrency._4_starvation;

import lombok.SneakyThrows;

import static org.digitalstack.concurrency._4_starvation.OnePersonKitchen.eat;

public class Person extends Thread {
    protected final OnePersonKitchen onePersonKitchen;
    protected String id;

    public Person(String id, OnePersonKitchen onePersonKitchen) {
        super(id);
        this.id = id;
        this.onePersonKitchen = onePersonKitchen;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (onePersonKitchen) {
                System.out.println(id + " eating ...");
                eat();
                System.out.println(id + " finished eating");
                onePersonKitchen.notifyAll(); //notify others that the kitchen is free now
                onePersonKitchen.wait();
            }
        }
    }
}