package demo;

import demo.entities.Course;
import demo.entities.Instructor;
import demo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

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

            Course course = session.get(Course.class, 1);

            System.out.println(course);

            session.delete(course);

            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //dealing with a connection leaks
            session.close();

            factory.close();
        }
    }
}
