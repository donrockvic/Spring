package com.code.hibernate;


import com.code.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            List<Student> theStudents = session.createQuery("from Student s where s.lastName='kumari'").getResultList();
            for(Student st: theStudents)
                System.out.println(st);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
