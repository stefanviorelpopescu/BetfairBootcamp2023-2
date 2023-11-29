package org.digitalstack.concurrency._3_good_coordination;

import lombok.SneakyThrows;

public class GoodCoordinationChannel implements IChannel {
    private String message;
    private boolean isChannelEmpty = true;

    @SneakyThrows
    public synchronized String take() {
        if (isChannelEmpty) {
            this.wait();
        }
        isChannelEmpty = true;
        notifyAll();
        return message;
    }


    @SneakyThrows
    public synchronized void put(String message) {
        if (!isChannelEmpty) {
            this.wait();
        }
        this.message = message;
        isChannelEmpty = false;
        this.notifyAll();
    }
}