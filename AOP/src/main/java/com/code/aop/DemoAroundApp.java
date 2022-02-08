package com.code.aop;

import com.code.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class DemoAroundApp {

    private static Logger logger = Logger.getLogger(DemoAroundApp.class.getName());

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\n Main Program: DemoAroundApp");

        logger.info("Calling getFortuneService");

        String data = trafficFortuneService.getFortune(true);

        logger.info("My fortune is "+data);

        context.close();
    }
}
