package com.code.rest.crm.controller;

import com.code.rest.crm.entity.Customer;
import com.code.rest.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer temp = customerService.getCustomer(customerId);
        if(temp==null)
            throw new CustomerNotFoundException("Customer with ID: "+customerId+" not found");

        customerService.deleteCustomer(customerId);
        return "Deleted customer with ID: "+customerId;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers(1);
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer==null){
            throw new CustomerNotFoundException("Customer id not Found - "+ customerId);
        }
        return customer;
    }

}
