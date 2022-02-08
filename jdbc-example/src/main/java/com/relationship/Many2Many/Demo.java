package com.relationship.Many2Many;

import com.relationship.Many2Many.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            Course course1 = new Course("guitar");
            Course course = new Course("testing");
            session.save(course);
            session.save(course1);
            Student student1 = new Student("vicky","kumar","vi.a@gmail.com");
            course.addStudent(student1);
            course1.addStudent(student1);
            session.save(student1);
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
