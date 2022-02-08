package com.spring.Money;

public class Sum implements Expression{
    Currency augment;
    Currency addmend;

    public Sum(Currency augment, Currency addmend) {
        this.augment = augment;
        this.addmend = addmend;
    }

    public Currency reduce(String to){
        int amount = augment.amount + addmend.amount;
        return new Currency(amount, to);
    }
}
