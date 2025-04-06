package com.hexaware.service;

import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;

import java.util.List;

public interface IBankServiceProvider {
    Account createAccount(Customer customer, String accountType, float balance);
    float deposit(long accNo, float amount);
    float withdraw(long accNo, float amount) throws Exception;
    boolean transfer(long fromAcc, long toAcc, float amount) throws Exception;
    float getAccountBalance(long accNo);
    Account getAccountDetails(long accNo);
    List<Account> listAccounts();
    void calculateInterest();
}
