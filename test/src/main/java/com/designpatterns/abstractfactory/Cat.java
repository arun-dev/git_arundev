package com.designpatterns.abstractfactory;

public class Cat implements Animal {
    @Override
    public String getType() {
        return "Cat";
    }

    @Override
    public String getEyeColour() {
        return "Blue";
    }
}
