package com.example.third;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortuneService(){
        return "Today is Your lucky day";
    }
}
