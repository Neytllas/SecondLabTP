package com.company;

public class Main {

    public static void main(String[] args) {
        Money money = new Money(100, Money.MoneyType.ruble);
        System.out.println(money);
    }
}
