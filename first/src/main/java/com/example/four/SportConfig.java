package com.example.four;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.example.four")
@PropertySource("classpath:application.properties")
public class SportConfig {
    @Bean
    public FortuneService fortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public SwimCoach swimCoach(){
        SwimCoach swimCoach = new SwimCoach(fortuneService());
        return swimCoach;
    }
}
