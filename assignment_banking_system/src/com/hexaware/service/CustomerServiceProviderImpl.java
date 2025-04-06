package com.hexaware.service;

import com.hexaware.entity.Account;
import java.util.List;

public class CustomerServiceProviderImpl {

    // This protected list allows extending classes to access accountList directly
    protected List<Account> accountList;

    // Constructor initializes the account list
    public CustomerServiceProviderImpl(List<Account> accountList) {
        this.accountList = accountList;
    }
}


