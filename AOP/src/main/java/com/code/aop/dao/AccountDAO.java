package com.code.aop.dao;

import com.code.aop.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCCode;

    public List<Account> findAccounts(boolean tripWire) throws Exception {
        if(tripWire){
            throw new RuntimeException("No Soup for you");
        }
        List<Account> accounts = new ArrayList<>();
        Account account = new Account("John", "gold");
        Account account1 = new Account("vicky", "Diamond");
        Account account2 = new Account("Mom", "superHero");
        Account account3 = new Account("Dad", "superHero");
        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }

    public void addAccount(Account account){
        System.out.println(getClass() + ": Doing my DB work Add Account");
    }

}
