package configtest.annotations.coaches;

import configtest.annotations.fortuneservices.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@Component("thatSillyCoach") - без него будет имя по умолчанию - tennisCoach
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneServiceImpl")
    //Field-Injection (Qualified)
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("В пустом конструкторе");
    }

    //@Autowired
    //Constructor-Injection
    public TennisCoach(FortuneService fortuneService) {
        System.out.println("В конструкторе с 1 аргументом");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDeailyWorkout() {
        return "Warm-up ur hands and spine muscles";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //@Autowired
    //Setter-Injection
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("В сеттере");
        this.fortuneService = fortuneService;
    }
}
