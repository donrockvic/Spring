package com.code.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class Analytics {

    @Before("com.code.aop.aspect.BaseAspect.forDAOPackage()")
    public void performAPIAnalytics(){
        System.out.println("==>Performing some fancy Analytics");
    }
}
