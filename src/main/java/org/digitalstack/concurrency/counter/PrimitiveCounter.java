package org.digitalstack.concurrency.counter;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class PrimitiveCounter implements Counter{

    int value = 0;

    public void increment() {
            value = value + 1;
    }
//    public void increment() {
////        int add = getNumberToAdd();
//        synchronized (this) {
//            value = value + 1;
//        }
//    }

    @SneakyThrows
    private int getNumberToAdd() {
        Thread.sleep(100);
        return 1;
    }
}
