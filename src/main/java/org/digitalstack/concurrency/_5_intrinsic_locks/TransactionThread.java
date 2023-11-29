package org.digitalstack.concurrency._5_intrinsic_locks;

public class TransactionThread extends Thread {
    private final BankAccount fromAccount;
    private final BankAccount toAccount;
    private final int amount;

    public TransactionThread(String name, BankAccount fromAccount, BankAccount toAccount, int amount) {
        super(name);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        transfer(fromAccount, toAccount, amount);
    }

    private boolean transfer(BankAccount fromAccount, BankAccount toAccount, int amount) {
        boolean success = false;
        synchronized (fromAccount) { //locking on intrinsic lock of 'fromAccount' Object
            fromAccount.withdraw(amount);
            synchronized (toAccount) { //locking on intrinsic lock of 'toAccount' Object
                toAccount.deposit(amount);
                success = true;
            }
        }
        return success;
    }
}