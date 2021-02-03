package com.luv2code.hibernate.demo.basiccrud;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentJava {
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

            session.delete(foundStudent);

            //DELETE 2
            session.createQuery("delete from Student where id = 2").executeUpdate();

            //commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
