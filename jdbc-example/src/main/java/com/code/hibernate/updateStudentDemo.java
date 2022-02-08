package com.code.hibernate;


import com.code.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class updateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            int id = 113;
//            Student st = session.get(Student.class, id);
//            st.setFirstName("navrattan");
            session.createQuery("update Student set lastName='rj' where firstName='navrattan'").executeUpdate();
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
