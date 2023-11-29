package org.digitalstack.concurrency._3_good_coordination;

public class GoodCoordinationExample {

    public static void main(String[] args) {
        IChannel channel = new GoodCoordinationChannel();

        (new Consumer(channel)).start();
        (new Producer(channel)).start();
    }

}
