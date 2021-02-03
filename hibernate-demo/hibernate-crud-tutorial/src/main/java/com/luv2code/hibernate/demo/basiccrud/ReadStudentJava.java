package com.luv2code.hibernate.demo.basiccrud;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentJava {
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
            System.out.println("Creating new student object...");
            Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            session.save(student);

            //commit transaction
            session.getTransaction().commit();

            //SEARCHING FOR A STUDENT
            session = factory.getCurrentSession();

            System.out.println("Saved student's ID: " + student.getId());

            //start a transaction
            session.beginTransaction();

            //get a student with the ID from the DB
            Student foundStudent = session.get(Student.class, student.getId());
            System.out.println("Get complete: " + foundStudent);

            //commit transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
