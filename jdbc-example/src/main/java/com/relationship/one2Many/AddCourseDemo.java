package com.relationship.one2Many;

import com.relationship.one2Many.entity.Course;
import com.relationship.one2Many.entity.Instructor;
import com.relationship.one2Many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseDemo {
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
            Course course1 = new Course("Guitar");
            Course course2 = new Course("Porn");
            session.beginTransaction();
            Instructor tempinst = session.get(Instructor.class, tempId);
            tempinst.add(course1);
            tempinst.add(course2);
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
