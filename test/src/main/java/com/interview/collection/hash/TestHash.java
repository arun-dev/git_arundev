package com.interview.collection.hash;

public class TestHash {
    public static void main(String[] args) {
        Money income = new Money(55, "USD");
        Money expenses = new Money(55, "USD");

        System.out.println(income.equals(expenses)); // false
        Money bonus = income;
        System.out.println(income.equals(bonus)); // true
        bonus.setAmount(44);
        System.out.println(income.equals(bonus)); // true
        System.out.println(income.getAmount());  // 44



    }
}
