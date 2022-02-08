package com.spring.Money;

public class Currency implements Expression {
    protected int amount;
    protected String currency;

    public Currency(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency(){
        return currency;
    };

    public Currency times(int _times){
        return new Currency(amount*_times, this.currency);
    }

    public static Currency dollar(int amount){
        return new Currency(amount, "USD");
    }

    public static Currency franc(int amount){
        return new Currency(amount, "FRNC");
    }

    public boolean equals(Object object){
        Currency _currency = (Currency) object;
        return  _currency.amount == amount && currency== _currency.currency;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression plus(Currency obj){
        return new Currency(amount+obj.amount, currency);
    }

    Currency reduce(Expression source, String to) {
        return source.reduce(to);
    }

    @Override
    public Currency reduce(String to) {

    }
}
