package com.example.four;

public class SadFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "You are very unlucky man";
    }
}
