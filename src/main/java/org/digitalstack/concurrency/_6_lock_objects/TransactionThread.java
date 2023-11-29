package org.digitalstack.concurrency._6_lock_objects;

public class TransactionThread extends Thread {
    private BankAccount from;
    private BankAccount to;
    private int amount;

    public TransactionThread(String name, BankAccount from, BankAccount to, int amount) {
        super(name);
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        transfer(from, to, amount);
    }

    private boolean transfer(BankAccount fromAccount, BankAccount toAccount, int amount) {
        boolean success = false;

        if (fromAccount.acquireLock()) {
            fromAccount.withdraw(amount); //because we pause work here, other threads have a chance to get lock on the other obj

            if (toAccount.acquireLock()) {
                toAccount.deposit(amount); //because we pause work here, other threads have a chance to get lock on the other obj
                toAccount.releaseLock();
                success = true;
            }

            if (!success) {
                fromAccount.deposit(amount); //in the case deposit was not successful, then we put the money back
            }
            fromAccount.releaseLock();
        }

        return success;
    }
}