package com.example.third;

import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService{
    @Override
    public String getFortuneService() {
        return "Better Luck next time dude";
    }
}
