package com.relationship.one2Many;

import com.relationship.one2Many.entity.Course;
import com.relationship.one2Many.entity.Instructor;
import com.relationship.one2Many.entity.InstructorDetail;
import com.relationship.one2Many.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class getCourseReview {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int theId = 1;
            Course course = session.get(Course.class, theId);
            System.out.println(course);
            System.out.println(course.getReviews());
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
