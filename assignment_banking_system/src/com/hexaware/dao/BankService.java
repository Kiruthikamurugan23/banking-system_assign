package com.hexaware.dao;

import com.hexaware.entity.Customer;
import com.hexaware.entity.Account;

import java.util.List;

public interface BankService {
    Account createAccount(Customer customer, String accType, float balance);
    List<Account> listAccounts();
    void calculateInterest();
}