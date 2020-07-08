package com.designpatterns.bridge;

public class Triangle extends Shape {
    public Triangle(Color color){
        super(color);
    }
    @Override
    public String draw() {
        return "Draw Triangle";
    }
}
