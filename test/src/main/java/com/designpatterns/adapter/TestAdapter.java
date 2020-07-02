package com.designpatterns.adapter;

public class TestAdapter {
    public static void main(String[] args) {
        Movable ferrari = new Ferrari();
        MovableAdapter ferrariAdapter = new MovableAdapterImpl(ferrari);
        System.out.println(ferrariAdapter.getSpeed());
    }


}
