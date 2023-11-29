package org.digitalstack.concurrency.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter{

    AtomicInteger value = new AtomicInteger(0);

    public void increment() {
        value.addAndGet(1);
    }

    @Override
    public int getValue() {
        return value.intValue();
    }
}
