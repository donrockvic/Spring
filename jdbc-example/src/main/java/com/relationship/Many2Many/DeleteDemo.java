package com.relationship.Many2Many;

import com.relationship.Many2Many.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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
            int courseId = 4;
            Course temp = session.get(Course.class, courseId);
            session.delete(temp);
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
