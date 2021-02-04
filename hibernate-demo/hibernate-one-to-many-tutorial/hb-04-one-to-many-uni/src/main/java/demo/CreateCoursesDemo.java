package demo;

import demo.entities.Course;
import demo.entities.Instructor;
import demo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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

            Instructor tempInsctructor = session.get(Instructor.class, 3);

            Course course1 = new Course("Air Guitar - the Ultimate Guide");
            Course course2 = new Course("The Pinball Masterclass");

            tempInsctructor.add(course1);
            tempInsctructor.add(course2);

            session.save(course1);
            session.save(course2);

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
