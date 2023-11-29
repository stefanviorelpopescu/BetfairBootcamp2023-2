package org.digitalstack.concurrency._5_intrinsic_locks;

import lombok.SneakyThrows;

public class BankAccount {
    private final String name;
    private int debit;

    public BankAccount(String name, int debit) {
        this.name = name;
        this.debit = debit;
    }

    void withdraw(int amount) {
        simulateLongDatabaseCall();
        this.debit -= amount;
    }

    void deposit(int amount) {
        simulateLongDatabaseCall();
        this.debit += amount;
    }

    @SneakyThrows
    private void simulateLongDatabaseCall() {
        Thread.sleep(100);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", debit=" + debit +
                '}';
    }
}