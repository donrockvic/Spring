package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();

    Employee getEmployee(int _id);

    void save(Employee employee);

    void deleteById(int id);
}
