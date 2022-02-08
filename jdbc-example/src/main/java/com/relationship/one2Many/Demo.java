package com.relationship.one2Many;

import com.relationship.one2Many.entity.Course;
import com.relationship.one2Many.entity.Instructor;
import com.relationship.one2Many.entity.InstructorDetail;
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
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            InstructorDetail instructorDetail1 = new InstructorDetail("rekha-ram", "gliding");
            Instructor instructor = new Instructor("Rekha", "pr", "prb@gmail.com", instructorDetail1);

            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
