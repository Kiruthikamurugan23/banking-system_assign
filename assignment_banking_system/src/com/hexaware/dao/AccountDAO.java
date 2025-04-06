package com.hexaware.dao;


import com.hexaware.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountDAO {

    // STEP 3: Insert account into the database
    public void insertAccount(int customerId, String accountType, double balance) {
        String sql = "INSERT INTO Accounts (customer_id, account_type, balance) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            stmt.setString(2, accountType);
            stmt.setDouble(3, balance);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " account(s) inserted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // STEP 4: Retrieve all accounts with customer info
    public void displayAccounts() {
        String sql = "SELECT a.account_id, c.name, a.account_type, a.balance " +
                     "FROM Accounts a JOIN Customers c ON a.customer_id = c.customer_id";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Account ID: " + rs.getInt("account_id"));
                System.out.println("Customer Name: " + rs.getString("name"));
                System.out.println("Account Type: " + rs.getString("account_type"));
                System.out.println("Balance: $" + rs.getDouble("balance"));
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
