package com.designpatterns.abstractfactory;

public class Crow implements Bird{
    @Override
    public String name() {
        return "Crow";
    }

    @Override
    public String eyeColour() {
        return "Black";
    }
}
