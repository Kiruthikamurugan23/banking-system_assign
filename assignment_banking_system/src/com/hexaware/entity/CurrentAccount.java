package com.hexaware.entity;

public class CurrentAccount extends Account {

    private float overdraftLimit = 10000.0f; // Default overdraft limit

    public CurrentAccount(float balance, Customer customer) {
        super(balance, customer);
    }

    @Override
    public void calculateInterest() {
        // Current accounts usually do not earn interest
        // No implementation needed
    }

    @Override
    public void withdraw(float amount) throws Exception {
        if (amount <= (getBalance() + overdraftLimit)) {
            setBalance(getBalance() - amount);
        } else {
            throw new Exception("❌ Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "AccountNo=" + getAccountNumber() +
                ", Balance=" + getBalance() +
                ", Customer=" + getCustomer().getFirstName() + " " + getCustomer().getLastName() +
                '}';
    }
}
