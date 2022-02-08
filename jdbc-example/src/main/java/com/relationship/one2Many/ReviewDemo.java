package com.relationship.one2Many;

import com.relationship.one2Many.entity.Course;
import com.relationship.one2Many.entity.Instructor;
import com.relationship.one2Many.entity.InstructorDetail;
import com.relationship.one2Many.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReviewDemo {
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
            Course course =  new Course("Tennis");
            Review review = new Review("Good one");
            course.add(review);
            course.add(new Review("Honestly don't like it."));
            course.add(new Review("yeah awesome"));
            session.save(course);
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
