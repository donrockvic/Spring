package com.code.aop.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class TrafficFortuneService {

    public String getFortune() throws InterruptedException {

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "Expect heavy traffic this morning!";
    }

    public String getFortune(boolean b) throws RuntimeException{
        if(b)
            throw new RuntimeException("Major Accident! Highway is Closed");
        return  "Exception one";
    }




}
