package com.luv2code.hibernate.demo.basiccrud;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentJava {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;

        try {
            //create session
            session = factory.getCurrentSession();

            //start a transaction
            session.beginTransaction();

            //query students
            System.out.println("List of all the students");
            List<Student> students = session.createQuery("from Student").getResultList();
            displayTheStudents(students);

            //query students: lastName = 'Doe'
            System.out.println("List of the students with lastName = 'Doe'");
            students = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
            displayTheStudents(students);

            //query students: lastName = 'Doe' OR firstName = 'Daffy'
            System.out.println("List of the students with lastName = 'Doe' OR firstName = 'Daffy'");
            students = session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName = 'Daffy'").getResultList();
            displayTheStudents(students);

            //query students: students with email LIKE '%luv2code.com'
            System.out.println("List of the students with email LIKE '%luv2code.com'");
            students = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
            displayTheStudents(students);

            //query students: students with email LIKE '%luv2code.com'
            System.out.println("List of the students with email LIKE '%gmail.com'");
            students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
            displayTheStudents(students);

            //save the student object
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }

    private static void displayTheStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("\n");
    }
}
