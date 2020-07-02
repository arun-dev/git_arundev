package com.designpatterns.abstractfactory;

public class Dog implements Animal{
    @Override
    public String getType() {
        return "Dog";
    }

    @Override
    public String getEyeColour() {
        return "Brown";
    }
}
