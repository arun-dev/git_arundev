package com.designpatterns.abstractfactory;

public class Parrot implements Bird{
    @Override
    public String name() {
        return "Parrot";
    }

    @Override
    public String eyeColour() {
        return "Yellow";
    }
}
