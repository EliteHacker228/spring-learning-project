package configtest.annotations.testplace;

import configtest.annotations.coaches.TennisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsConfigDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:annotations-res/applicationContext.xml");

        TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(coach.getDeailyWorkout());
        System.out.println(coach.getDailyFortune());

        context.close();
    }
}
