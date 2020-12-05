package configtest.javacode.coaches;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class CricketCoach implements Coach {

    @Value("${foo.team}")
    private String team;

    @Value("${foo.email}")
    private String email;

    @Override
    public String getDailyWorkout(){
        return "Do some workout";
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
