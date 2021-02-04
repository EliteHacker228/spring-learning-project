package demo;

import demo.entities.Course;
import demo.entities.Instructor;
import demo.entities.InstructorDetail;
import demo.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

            Course tempCourse = new Course("Pacman 3 - How To Score One Million Points");

            tempCourse.addReview(new Review("Great Course!"));
            tempCourse.addReview(new Review("Cool Course! "));
            tempCourse.addReview(new Review("Bad >:("));

            //Course c1 = session.get(Course.class, 10);
            //session.delete(c1);

            session.save(tempCourse);

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
