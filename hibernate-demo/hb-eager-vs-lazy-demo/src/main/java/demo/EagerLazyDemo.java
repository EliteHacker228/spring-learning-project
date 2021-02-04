package demo;

import demo.entities.Course;
import demo.entities.Instructor;
import demo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EagerLazyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();


            session.beginTransaction();

            Instructor tempInstructor = session.get(Instructor.class, 3);

            System.out.println(tempInstructor);

            System.out.println(tempInstructor.getCourses());

            session.getTransaction().commit();

            System.out.println(tempInstructor.getCourses());

            System.out.println("luv2 c code: Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //dealing with a connection leaks
            session.close();

            factory.close();
        }
    }
}
