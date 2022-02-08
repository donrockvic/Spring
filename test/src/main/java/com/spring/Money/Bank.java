package com.spring.Money;

public class Bank {
    public Currency reduce(Expression expression, String curr){
        if(expression instanceof Currency) return (Currency) expression;
        Sum sum = (Sum) expression;
        return sum.reduce(curr);
    }
}
