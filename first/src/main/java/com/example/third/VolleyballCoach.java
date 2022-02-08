package com.example.third;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach{
    @Autowired
    @Qualifier("sadFortuneService")
    private FortuneService myFortuneService;

//    @Autowired
//    public void setMyFortuneService(FortuneService myFortuneService) {
//        this.myFortuneService = myFortuneService;
//    }

    public VolleyballCoach() {
        System.out.println(">> Volleyball: inside default constructors");
    }

    @Override
    public String getDailyWorkout() {
        return "500 blocks and smashes";
    }

    @Override
    public String getDailyFortune() {
        return myFortuneService.getFortuneService();
    }
}
