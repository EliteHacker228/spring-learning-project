package configtest.xml.fortuneservices;


import java.util.Random;

public class RandomFortuneService implements FortuneService {

    String[] fortunes = {"Goodluck bro!", "Good luck, ashen one!", "That's your lucky day!"};
    Random random = new Random();

    public String getFortune() {
        return fortunes[random.nextInt(3)];
    }
}
