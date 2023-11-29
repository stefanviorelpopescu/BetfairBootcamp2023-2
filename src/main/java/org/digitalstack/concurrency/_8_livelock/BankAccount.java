package org.digitalstack.concurrency._8_livelock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    String name;
    int debit;
    private Lock lock = new ReentrantLock(true);

    public BankAccount(String name, int debit) {
        this.name = name;
        this.debit = debit;
    }

    public boolean acquireLock() {
        return lock.tryLock(); //can result in livelock
    }

    public void releaseLock() {
        lock.unlock();
    }

    void withdraw(double amount) {
        simulateLongDatabaseCall();
        this.debit -= amount;
    }

    void deposit(double amount) {
        simulateLongDatabaseCall();
        this.debit += amount;
    }

    private void simulateLongDatabaseCall() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", debit=" + debit +
                '}';
    }
}