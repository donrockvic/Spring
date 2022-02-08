package com.code.hibernate;


import com.code.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class deleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            int id = 114;
            Student st = session.get(Student.class, id);
            session.delete(st);
            session.createQuery("delete from Student where id=112").executeUpdate();
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
