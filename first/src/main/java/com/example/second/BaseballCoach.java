package com.example.second;

import org.springframework.beans.factory.DisposableBean;

public class BaseballCoach implements Coach, DisposableBean {

    private final HappyFortuneService myFortuneService;

    public BaseballCoach(HappyFortuneService myFortuneService) {
        this.myFortuneService = myFortuneService;
    }

    @Override
    public String getDailyFortune() {
        return this.myFortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    public void doMyStartupStuff(){
        System.out.println("BaseballCoach: inside method doMyStartupStuff");
    }

    public void doMyCleanupStuff(){
        System.out.println("BaseballCoach: inside method doMyCleanupStuff");
    }

    @Override
    public void destroy(){
        System.out.println("BaseballCoach: inside method doMyCleanupStuff");
    }

}
