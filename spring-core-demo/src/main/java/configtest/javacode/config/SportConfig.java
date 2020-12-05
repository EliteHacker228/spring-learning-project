package configtest.javacode.config;

import configtest.javacode.coaches.Coach;
import configtest.javacode.coaches.CricketCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("configtest.javacode")
@PropertySource("classpath:javacode-res/props.properties")
public class SportConfig {

    public SportConfig(){
        System.out.println("In empty constructor");
    }

    @Bean
    public Coach cricketCoach(){
        CricketCoach coach = new CricketCoach();
        return coach;
    }
}
