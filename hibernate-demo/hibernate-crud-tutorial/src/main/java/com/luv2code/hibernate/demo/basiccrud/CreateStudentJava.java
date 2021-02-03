package com.luv2code.hibernate.demo.basiccrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentJava {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;

        try {
            //ADDING A STUDENT
            session = factory.getCurrentSession();

            //create a student object
            Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            session.save(student);

            //commit transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
