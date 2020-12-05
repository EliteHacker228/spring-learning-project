package configtest.xml.testplace;


import configtest.xml.coaches.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigDemo {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xml-res/applicationContext.xml");

        CricketCoach coach = context.getBean("myCoach", CricketCoach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getEmail());
        System.out.println(coach.getTeam());

        context.close();
    }
}
