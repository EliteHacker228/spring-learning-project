package com.luv2code.hibernate.demo.basiccrud;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentJava {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;

        try {

            int studentId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            //get a student with the ID from the DB
            System.out.println("\nGetting a student with id: " + studentId);

            Student foundStudent = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            foundStudent.setFirstName("Scooby");

            //commit transaction
            session.getTransaction().commit();

            //NEW CODE

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email for all students");

            session.createQuery("update Student set email = 'foo@gmail.com'")
                    .executeUpdate();

            session.getTransaction().commit();;
        } finally {
            session.close();
        }
    }
}
