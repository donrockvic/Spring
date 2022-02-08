package com.code.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BaseAspect {
    @Pointcut("execution(* com.code.aop.dao.AccountDAO.find*(..))")
    public void forDAOPackage(){}

    @Pointcut("execution(* get*(..))")
    private void getter(){}

    @Pointcut("execution(* set*(..))")
    private void setter(){}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void rule(){}
}
