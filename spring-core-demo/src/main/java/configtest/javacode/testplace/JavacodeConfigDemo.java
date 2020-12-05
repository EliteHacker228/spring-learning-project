package configtest.javacode.testplace;

import configtest.javacode.coaches.CricketCoach;
import configtest.javacode.config.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavacodeConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getTeam());
        System.out.println(coach.getEmail());
    }
}
