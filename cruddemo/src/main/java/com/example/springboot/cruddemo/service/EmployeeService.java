package com.example.springboot.cruddemo.service;

import com.example.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployee(int _id);

    void save(Employee employee);

    void deleteById(int id);
}
