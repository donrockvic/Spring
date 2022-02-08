package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {

        Query query = entityManager.createQuery("from Employee");

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee getEmployee(int _id) {
        Employee employee = entityManager.find(Employee.class, _id);
        return  employee;
    }

    @Override
    public void save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        // update with id from te db
        // so that we can get generated id for save and insert
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id:empID");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
