package configtest.annotations.fortuneservices;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneServiceImpl implements FortuneService {

    String[] fortunes = {"Goodluck bro!", "Good luck, ashen one!", "That's your lucky day!"};
    Random random = new Random();

    @Override
    public String getFortune() {
        return fortunes[random.nextInt(3)];
    }
}
