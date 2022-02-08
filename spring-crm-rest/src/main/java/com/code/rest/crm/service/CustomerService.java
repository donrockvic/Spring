package com.code.rest.crm.service;

import com.code.rest.crm.entity.Customer;

import java.util.List;

public interface CustomerService  {

    List<Customer> getCustomers(int sortField);

    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
