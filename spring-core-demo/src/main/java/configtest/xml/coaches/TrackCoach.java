package configtest.xml.coaches;


import configtest.xml.fortuneservices.FortuneService;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {

    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "TRACK TRACK TRACK TRACK TRACK";
    }

    public String getDailyFortune() {
        return "My message for today: " + fortuneService.getFortune();
    }
}
