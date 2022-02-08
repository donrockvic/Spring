package com.relationship.one2one;


import com.relationship.one2one.entity.Instructor;
import com.relationship.one2one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();

            InstructorDetail instructorDetail1 = new InstructorDetail("madhu-ram", "gliding");

            Instructor instructor = new Instructor("Madhu", "kumar", "mk@gmail.com", instructorDetail1);

            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
