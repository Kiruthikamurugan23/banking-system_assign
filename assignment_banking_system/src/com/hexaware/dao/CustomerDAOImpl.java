package com.hexaware.dao;

import com.hexaware.entity.Customer;
import com.hexaware.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements ICustomerDAO {

    // Insert a new customer into the database
    @Override
    public void insertCustomer(Customer customer) throws Exception {
        String sql = "INSERT INTO Customers (name, email, phone, address) VALUES (?, ?, ?, ?)";

        // Try-with-resources to ensure resources are closed
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, customer.getFirstName() + " " + customer.getLastName()); // Combining first and last name
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getAddress());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Customer inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error inserting customer: " + e.getMessage());
            throw e;
        }
    }

    // Retrieve all customers from the database
    @Override
    public List<Customer> getAllCustomers() throws Exception {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customers"; // Assuming customer_id is auto-incremented

        // Try-with-resources to handle closing of resources automatically
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Customer customer = new Customer(sql, sql, sql, sql, sql);
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("name").split(" ")[0]); // Extract first name
                customer.setLastName(rs.getString("name").split(" ")[1]); // Extract last name
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));

                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error retrieving customers: " + e.getMessage());
            throw e;
        }

        return customers;
    }

}

