package com.example.springboot.cruddemo.service;

import com.example.springboot.cruddemo.dao.EmployeeDAO;
import com.example.springboot.cruddemo.dao.EmployeeRepository;
import com.example.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
//    private EmployeeDAO employeeDAO;
//
//    @Autowired
//    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }


    private EmployeeRepository  employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int _id) {
        Optional<Employee> result = employeeRepository.findById(_id);
        Employee employee = null;

        if(result.isPresent())
            employee = result.get();

        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

//    @Override
//    @Transactional
//    public List<Employee> getEmployees() {
//        return employeeDAO.getEmployees();
//    }
//
//    @Override
//    @Transactional
//    public Employee getEmployee(int _id) {
//        return employeeDAO.getEmployee(_id);
//    }
//
//    @Override
//    @Transactional
//    public void save(Employee employee) {
//        employeeDAO.save(employee);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(int id) {
//        employeeDAO.deleteById(id);
//    }
}
