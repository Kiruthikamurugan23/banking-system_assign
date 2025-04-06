package com.hexaware.dao;


import com.hexaware.entity.Customer;
import java.util.List;

public interface ICustomerDAO {
    void insertCustomer(Customer customer) throws Exception;
    List<Customer> getAllCustomers() throws Exception;
}