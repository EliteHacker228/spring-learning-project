package configtest.xml.coaches;


import configtest.xml.fortuneservices.FortuneService;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout(){
        return "Do some baseball bat thing";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
