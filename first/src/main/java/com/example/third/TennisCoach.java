package com.example.third;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
    FortuneService fortuneService;

    @Autowired
    public TennisCoach(HappyFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your back hand volley";
    }

    @Override
    public String getDailyFortune(){
        return fortuneService.getFortuneService();
    }



}
