package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    public void testRToString()
    {
        Money money = new Money(100, Money.MoneyType.ruble);
        assertEquals("100.0 Рубликов", money.toString());
    }

    @Test
    public void testDToString()
    {
        Money money = new Money(100, Money.MoneyType.dollar);
        assertEquals("100.0 ДоллАров", money.toString());
    }

    @Test
    public void testEToString()
    {
        Money money = new Money(100, Money.MoneyType.euro);
        assertEquals("100.0 Еуров", money.toString());
    }

    @Test
    public void testAddNimber()
    {
        Money money = new Money(100, Money.MoneyType.euro);
        money = money.add(123);
        assertEquals("223.0 Еуров", money.toString());
    }

    @Test
    public void testSubtractNumber() {
        Money money = new Money(100, Money.MoneyType.euro);
        money = money.subtract(5);
        assertEquals("95.0 Еуров", money.toString());
    }

    @Test
    public void testMultiplyByNumber() {
        Money money = new Money(100, Money.MoneyType.euro);
        money = money.multiply(5);
        assertEquals("500.0 Еуров", money.toString());
    }

    @Test
    public void testDivideByNumber() {
        Money money = new Money(100, Money.MoneyType.euro);
        money = money.divide(5);
        assertEquals("20.0 Еуров", money.toString());
    }

    @Test
    public void testConvertRubleToAny() {
        Money money;

        money = new Money(1000, Money.MoneyType.ruble);
        assertEquals("13.0 ДоллАров", money.to(Money.MoneyType.dollar).toString());

        money = new Money(169 * 2, Money.MoneyType.ruble);
        assertEquals("3.718 Еуров", money.to(Money.MoneyType.euro).toString());
    }

}