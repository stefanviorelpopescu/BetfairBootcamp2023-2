package org.digitalstack.concurrency;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("I am a Thread");
    }
}
