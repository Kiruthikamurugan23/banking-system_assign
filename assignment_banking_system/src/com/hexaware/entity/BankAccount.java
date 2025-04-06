package com.hexaware.entity;

public class BankAccount extends Account {

    public BankAccount(float balance, Customer customer) {
        super(balance, customer);
    }

    @Override
    public void calculateInterest() {
        float interest = getBalance() * 0.02f; // 2% interest
        setBalance(getBalance() + interest);
    }

    @Override
    public void withdraw(float amount) throws Exception {
        if (getBalance() < amount) {
            throw new Exception("Insufficient balance.");
        }
        setBalance(getBalance() - amount);
    }
}


