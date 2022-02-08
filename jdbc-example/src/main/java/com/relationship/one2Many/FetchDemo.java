package com.relationship.one2Many;

import com.relationship.one2Many.entity.Course;
import com.relationship.one2Many.entity.Instructor;
import com.relationship.one2Many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            int tempId = 4;
            session.beginTransaction();
            Instructor tempInt = session.get(Instructor.class, tempId);
            System.out.println(tempInt);
            System.out.println(tempInt.getCourseList());
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
