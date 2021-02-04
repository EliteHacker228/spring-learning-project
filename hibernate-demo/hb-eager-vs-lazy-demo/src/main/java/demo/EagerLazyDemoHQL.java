package demo;

import demo.entities.Course;
import demo.entities.Instructor;
import demo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EagerLazyDemoHQL {
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

            Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses WHERE i.id =: theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", 3);

            Instructor tempInstructor = query.getSingleResult();

            System.out.println(tempInstructor);

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
