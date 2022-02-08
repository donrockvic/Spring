package com.code.crm.dao;

import com.code.crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.crm.util.SortUtil;

import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory hibernateSessionFactory;

    @Override
    public List<Customer> getCustomers(int sortField) {
        Session session = hibernateSessionFactory.getCurrentSession();

        String sortFieldName = null;
        switch (sortField){
            case SortUtil.FIRST_NAME:
                sortFieldName = "firstName";
                break;
            case SortUtil.EMAIL:
                sortFieldName = "email";
                break;
            default:
                sortFieldName = "lastName";
        }

        String queryString = "from Customer order by " + sortFieldName;

        Query<Customer> query = session.createQuery(queryString, Customer.class);
        List<Customer>  customers = query.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = hibernateSessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session session = hibernateSessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, theId);
        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session session = hibernateSessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, theId);
        session.delete(customer);
    }
}
