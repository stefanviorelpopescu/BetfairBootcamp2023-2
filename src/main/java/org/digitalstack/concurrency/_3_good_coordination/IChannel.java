package org.digitalstack.concurrency._3_good_coordination;

public interface IChannel {

    String take();

    void put(String message);
}
