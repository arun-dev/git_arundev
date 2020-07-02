package com.designpatterns.bridge;

public class Square extends Shape {

    public Square(Color color){
        super(color);
    }
    @Override
    public String draw() {
        return "Drawing Square";
    }
}
