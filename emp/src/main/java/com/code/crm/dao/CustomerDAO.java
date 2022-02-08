package com.code.crm.dao;

import com.code.crm.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers(int sortField);
    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
