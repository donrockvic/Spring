package com.spring.Money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    void testMultiplicationCurrency() {
        Currency five = Currency.dollar(5);
        assertEquals(Currency.dollar(10), five.times(2));
        assertEquals(Currency.dollar(15), five.times(3));

        Currency two = Currency.franc(2);
        assertEquals(Currency.franc(4), two.times(2));
    }

    @Test
    void testEqualityCurrency() {
        assertEquals(Currency.dollar(5), Currency.dollar(5));
        assertNotEquals(Currency.dollar(5), Currency.dollar(8));

        assertEquals(Currency.franc(5), Currency.franc(5));
        assertNotEquals(Currency.dollar(5), Currency.franc(8));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Currency.dollar(1).currency());
        assertEquals("FRNC", Currency.franc(1).currency());
    }

    @Test
    void testSimpleAddition() {
        Currency five = Currency.dollar(5);
        Expression sum = five.plus(five);

        Bank bank = new Bank();

        Currency reduced = bank.reduce(sum, "USD");
        assertEquals(Currency.dollar(10), reduced);
    }

//    @Test
//    void testPlusReturnsSum() {
//        Currency five = Currency.dollar(5);
//        Expression result = five.plus(five);
//
//        Sum sum = (Sum) result;
//        assertEquals(five, sum.addmend);
//        assertEquals(five, sum.augment);
//    }

    @Test
    void testReduceSum() {
       Expression sum = new Sum(Currency.dollar(3), Currency.dollar(4));
       Bank bank = new Bank();
       Currency result  = bank.reduce(sum, "USD");
       assertEquals(Currency.dollar(7), result);
    }

    @Test
    void testReduceCurrency() {
        Bank bank = new Bank();
        Currency currency =  bank.reduce(Currency.dollar(1), "USD");
        assertEquals(Currency.dollar(1), currency);
    }
}
