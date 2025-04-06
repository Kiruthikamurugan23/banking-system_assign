package com.hexaware.entity;

public abstract class Account {
    private static long counter = 1000;
    private long accountNumber;
    private float balance;
    private Customer customer;

    public Account(float balance, Customer customer) {
        this.accountNumber = ++counter;
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public abstract void withdraw(float amount) throws Exception;

	public void calculateInterest() {
		// TODO Auto-generated method stub
		
	}
}



