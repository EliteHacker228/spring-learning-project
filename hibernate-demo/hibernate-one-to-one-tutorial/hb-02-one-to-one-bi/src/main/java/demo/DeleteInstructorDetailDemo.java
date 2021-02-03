package demo;

import demo.entities.Instructor;
import demo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
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

           InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, 3);

            System.out.println(tempInstructorDetail);
            System.out.println('\n');
            System.out.println(tempInstructorDetail.getInstructor());
            System.out.println('\n');

            //remove the associated object reference
            //break bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //dealing with a connection leaks
            session.close();

            factory.close();
        }
    }
}
