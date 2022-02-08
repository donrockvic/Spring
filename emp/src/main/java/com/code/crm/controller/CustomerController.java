package com.code.crm.controller;

import com.code.crm.entity.Customer;
import com.code.crm.service.CustomerService;
import com.code.crm.util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model theModel, @RequestParam(required = false) String sort){

        List<Customer> customerList = null;

        if(sort!=null){
            int sortField = Integer.parseInt(sort);
            customerList = customerService.getCustomers(sortField);
        }else{
            customerList = customerService.getCustomers(SortUtil.LAST_NAME);
        }


        theModel.addAttribute("customers", customerList);
        return "list-customer";
    }

    @GetMapping("/addForm")
    public String showAddForm(Model theModel){
        Customer customer = new Customer();
        theModel.addAttribute("customer", customer);
        return "show-add-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("customerId") int theId, Model theModel){
        Customer customer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", customer);
        return "show-add-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId, Model theModel){
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }

}
