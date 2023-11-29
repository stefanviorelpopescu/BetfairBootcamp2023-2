package org.digitalstack.concurrency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // complicated logic
        return 5;
    }
}
