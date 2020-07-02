package com.designpatterns.abstractfactory;

public class BirdFactory implements AbstractFactory<Bird>{
    @Override
    public Bird create(String type) {
        if(type.equals("Parrot")){
            return new Parrot();
        }
        return new Crow();
    }
}
