package com.code.hibernate;


import com.code.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{

            Student student1 =  new Student("kelii", "adsd", "ad@gmail.com");
            // Student student2 =  new Student("john", "paul", "john@gmail.com");

            session.beginTransaction();

            session.save(student1);
            // session.save(student2);

            session.getTransaction().commit();


            System.out.println("saved Student ID: "+ student1.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("getting the detail of Student: "+ student1.getId());
            Student temp = session.get(Student.class, student1.getId());

            session.getTransaction().commit();
            System.out.println(temp);


        }finally {
            factory.close();
        }
    }
}
