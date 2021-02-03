package demo;

import demo.entities.Instructor;
import demo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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

            session.beginTransaction();

            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);
            System.out.println(tempInstructor);

            if(tempInstructor != null){

                session.delete(tempInstructor);
            }

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
