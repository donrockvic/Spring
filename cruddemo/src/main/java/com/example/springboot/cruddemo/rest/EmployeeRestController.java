package com.example.springboot.cruddemo.rest;


import com.example.springboot.cruddemo.dao.EmployeeDAO;
import com.example.springboot.cruddemo.entity.Employee;
import com.example.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getCustomers(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getCustomer(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/employees/{id}")
    public String delEmp(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee==null)
            throw new RuntimeException("Employee id not Found - "+id);
        employeeService.deleteById(id);
        return "Deleted the Employee successfully";
    }

    @PostMapping("/employees")
    public Employee addCustomer(@RequestBody Employee theCustomer){
        theCustomer.setId(0);
        employeeService.save(theCustomer);
        return theCustomer;
    }
}
