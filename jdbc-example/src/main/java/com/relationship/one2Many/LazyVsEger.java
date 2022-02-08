package com.relationship.one2Many;

import com.relationship.one2Many.entity.Course;
import com.relationship.one2Many.entity.Instructor;
import com.relationship.one2Many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LazyVsEger {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
