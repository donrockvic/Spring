package com.code.crm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.code.crm.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.code.crm.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.code.crm.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() ||forDAOPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("Entering method "+theMethod);

        Object[] args = joinPoint.getArgs();
        for (Object tempArg: args)
            logger.info("arguments are "+tempArg);
    }


    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void forAfterReturning(JoinPoint joinPoint, Object theResult){
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("Exiting method "+theMethod);

        logger.info("Result "+theResult );
    }
}
