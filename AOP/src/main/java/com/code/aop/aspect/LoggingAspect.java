package com.code.aop.aspect;

import com.code.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class LoggingAspect{

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* getFortune(..))")
    public Object afterGetFortune(ProceedingJoinPoint joinPoint) throws Throwable{
       String method = joinPoint.getSignature().toShortString();

       logger.info("Currenly calling: "+method);

       long begin = System.currentTimeMillis();
       Object result = null;

       try{
           result = joinPoint.proceed();
       }catch (Exception exc){
           logger.severe("@Arround Advice: We are having an issue");
            result = "Issue was there";
       }

       long end = System.currentTimeMillis();

       long duration = end - begin;
       logger.info("Time: "+duration/1000+" Milliseconds");
       return result;
    }


    @After("execution(* com.code.aop.dao.AccountDAO.find*(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
        System.out.println("After Finally happened");
    }


    @AfterThrowing(
            pointcut = "execution(* com.code.aop.dao.AccountDAO.find*(..))",
            throwing =  "throwable"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable throwable){
        logger.info("Boom it happened");
        String method = joinPoint.getSignature().toLongString();

        logger.info("\n==> Executing @AfterThrowing on method:"+ method);

        logger.info("==> The Exception is: "+throwable);
    }

    @AfterReturning(
            pointcut = "execution(* com.code.aop.dao.AccountDAO.find*(..))",
            returning = "result"
    )
    public void afterReturningAccountAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toLongString();

        logger.info("\n==> Executing @AfterReturning on method:"+ method);
        logger.info("\n==> Result is:"+ result);


        // Modifying the data
        convertOutput(result);
    }

    private void convertOutput(List<Account> accounts){
        for(Account account: accounts){
            account.setName(account.getName().toUpperCase(Locale.ROOT));
        }
    }

    @Before("com.code.aop.aspect.BaseAspect.rule()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("==> Executing @Before advice on addAccount()");

        // Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method Signature: "+ methodSignature);

        // display the method arguments
        Object[] args = joinPoint.getArgs();
        logger.info("Printing the argument");
        for(Object tempArg: args){
            System.out.println(tempArg);
        }

    }
}
