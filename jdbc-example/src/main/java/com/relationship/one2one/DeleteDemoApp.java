package com.relationship.one2one;


import com.relationship.one2one.entity.Instructor;
import com.relationship.one2one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemoApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            int theId = 2;
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, theId);
            System.out.println(instructor);
            if(instructor!=null){
                System.out.println("about to delete");
                session.delete(instructor);
            }
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
