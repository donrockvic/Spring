package com.example.four;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    private final HappyFortuneService myFortuneService;

    @Autowired
    public TrackCoach(HappyFortuneService myFortuneService) {
        this.myFortuneService = myFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard four 5k";
    }

    @Override
    public String getDailyFortune() {
        return this.myFortuneService.getFortune();
    }
}
