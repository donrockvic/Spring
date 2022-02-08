package com.example.second;

public class CricketCoach implements Coach{
    private String emailAddress;
    private String team;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    private HappyFortuneService fortuneService;

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-args constructor");
    }

    public void setFortuneService(HappyFortuneService myFortuneService) {
        System.out.println("CricketCoach: inside setter method");
        this.fortuneService = myFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
