package demo;

import demo.entities.Instructor;
import demo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = null;

        try {
            //ADDING A STUDENT
            session = factory.getCurrentSession();

            /*Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("https://www.luv2code.com/youtube", "Luv 2 code!!!");*/

            Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("https://www.youtube.com", "Guitar");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            session.save(tempInstructor);


            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
