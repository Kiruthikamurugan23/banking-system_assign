package com.hexaware.service;

public interface ICustomerServiceProvider {
    float deposit(long accNo, float amount);
    float withdraw(long accNo, float amount) throws Exception;
    boolean transfer(long fromAcc, long toAcc, float amount) throws Exception;
    float getAccountBalance(long accNo);
    String getAccountDetails(long accNo);
}
