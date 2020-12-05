package configtest.annotations.fortuneservices;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

    @Override
    public String getFortune() {
        return "Good luck!";
    }
}
