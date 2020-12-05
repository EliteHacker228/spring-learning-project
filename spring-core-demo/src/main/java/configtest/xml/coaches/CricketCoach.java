package configtest.xml.coaches;


import configtest.xml.fortuneservices.FortuneService;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    private String email;
    private String team;

    public CricketCoach() {
        System.out.println("Inside no-args CricketCoach constructor");
    }

    public CricketCoach(FortuneService fortuneService) {
        System.out.println("Inside 1-arg CricketCoach constructor");
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Swing your crocket bat";
    }

    public String getDailyFortune() {
        return "Cricket coach says: " + fortuneService.getFortune();
    }


    private void initMethod(){
        System.out.println("initMethod() invocation");
    }

    private void destroyMethod(){
        System.out.println("destroyMethod() invocation");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println("In set-email method");
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("In set-team method");
        this.team = team;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Inside setter");
        this.fortuneService = fortuneService;
    }
}
