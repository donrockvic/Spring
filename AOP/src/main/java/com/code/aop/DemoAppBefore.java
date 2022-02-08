package com.code.aop;

import com.code.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoAppBefore {

    public static void main(String[] args) {
        // Read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business logic
        Account account =  new Account("vicky", "WholeAnotherr");
        accountDAO.addAccount(account);
        System.out.println();
        System.out.println("calling again");
        accountDAO.addAccount(account);

        // close the context
        context.close();
    }

}
