package com.hexaware.dao;

import com.hexaware.entity.*;
import com.hexaware.service.IBankServiceProvider;
import com.hexaware.service.CustomerServiceProviderImpl;

import java.util.ArrayList;
import java.util.List;

public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider {

    private String branchName;
    private String branchAddress;

    public BankServiceProviderImpl(String branchName, String branchAddress) {
        super(new ArrayList<>());  // Initializes the accountList
        this.branchName = branchName;
        this.branchAddress = branchAddress;
    }

    @Override
    public Account createAccount(Customer customer, String accType, float balance) {
        Account acc = null;

        switch (accType.toLowerCase()) {
            case "savings":
                acc = new SavingsAccount(balance, customer, 4.0f); // 4% interest
                break;
            case "current":
                acc = new CurrentAccount(balance, customer);
                break;
            case "zerobalance":
                acc = new ZeroBalanceAccount(balance, customer);
                break;
            default:
                System.out.println("❌ Invalid account type.");
                return null;
        }

        accountList.add(acc);
        return acc;
    }

    @Override
    public float deposit(long accNo, float amount) {
        for (Account acc : accountList) {
            if (acc.getAccountNumber() == accNo) {
                acc.setBalance(acc.getBalance() + amount);
                return acc.getBalance();
            }
        }
        System.out.println("❌ Account not found.");
        return 0;
    }

    @Override
    public float withdraw(long accNo, float amount) throws Exception {
        for (Account acc : accountList) {
            if (acc.getAccountNumber() == accNo) {
                acc.withdraw(amount);
                return acc.getBalance();
            }
        }
        throw new Exception("❌ Account not found.");
    }

    @Override
    public boolean transfer(long fromAcc, long toAcc, float amount) throws Exception {
        Account sender = null;
        Account receiver = null;

        for (Account acc : accountList) {
            if (acc.getAccountNumber() == fromAcc) sender = acc;
            if (acc.getAccountNumber() == toAcc) receiver = acc;
        }

        if (sender != null && receiver != null) {
            sender.withdraw(amount);
            receiver.setBalance(receiver.getBalance() + amount);
            return true;
        }

        throw new Exception("❌ One or both accounts not found.");
    }

    @Override
    public float getAccountBalance(long accNo) {
        for (Account acc : accountList) {
            if (acc.getAccountNumber() == accNo) {
                return acc.getBalance();
            }
        }
        System.out.println("❌ Account not found.");
        return 0;
    }

    @Override
    public Account getAccountDetails(long accNo) {
        for (Account acc : accountList) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        System.out.println("❌ Account not found.");
        return null;
    }

    @Override
    public List<Account> listAccounts() {
        return accountList;
    }

    @Override
    public void calculateInterest() {
        for (Account acc : accountList) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).calculateInterest();
            }
        }
    }

    // Optional: Getters for branch info
    public String getBranchName() {
        return branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }
}
