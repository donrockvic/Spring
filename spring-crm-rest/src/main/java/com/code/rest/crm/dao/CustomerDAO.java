package com.code.rest.crm.dao;

import com.code.rest.crm.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers(int sortField);

    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
