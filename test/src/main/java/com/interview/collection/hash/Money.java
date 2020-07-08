package com.interview.collection.hash;

public class Money {
    private int amount;
    private String currencyCode;

    public Money(int amount, String currencyCode){
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
}
