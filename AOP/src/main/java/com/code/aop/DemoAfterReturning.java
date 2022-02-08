package com.code.aop;

import com.code.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class DemoAfterReturning {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = accountDAO.findAccounts(false);

        System.out.println("\n Main Program: DemoAfterReturning");
        System.out.println("-----------------------------------");
        System.out.println(accountList);
        System.out.println("-----------------------------------");

        context.close();
    }
}
