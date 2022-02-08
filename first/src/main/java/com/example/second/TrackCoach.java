package com.example.second;

public class TrackCoach implements Coach {

    private final HappyFortuneService myFortuneService;

    public TrackCoach(HappyFortuneService myFortuneService) {
        this.myFortuneService = myFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return this.myFortuneService.getFortune();
    }
}
