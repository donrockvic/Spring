package com.example.third;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class application {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("third-applicationContext.xml");

        TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);
        VolleyballCoach vCoach = context.getBean("volleyballCoach", VolleyballCoach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        System.out.println(vCoach.getDailyFortune());
        System.out.println(vCoach.getDailyWorkout());
        // close the context
        context.close();
    }
}
