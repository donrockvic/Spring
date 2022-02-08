package com.relationship.one2one;


import com.relationship.one2one.entity.Instructor;
import com.relationship.one2one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDeleteDemoApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            int theId = 3;
            session.beginTransaction();
            InstructorDetail instructorDetail =  session.get(InstructorDetail.class, theId);
            System.out.println(instructorDetail);
            System.out.println(instructorDetail.getInstructor());
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
