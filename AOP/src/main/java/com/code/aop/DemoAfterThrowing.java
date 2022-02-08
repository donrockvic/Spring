package com.code.aop;

import com.code.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class DemoAfterThrowing {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        try{
            List<Account> accountList = accountDAO.findAccounts(true);
        }catch (Exception e){
            System.out.println("Exception Found: "+e);
        }


        System.out.println("\n Main Program: DemoAfterThrowing");
        System.out.println("-----------------------------------");

        context.close();
    }
}
