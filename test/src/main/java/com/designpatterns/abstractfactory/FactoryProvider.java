package com.designpatterns.abstractfactory;

public class FactoryProvider{
    public static AbstractFactory getFactory (final String choice){
        if(choice.equals("Animal")){
            return new AnimalFactory();
        }
        return new BirdFactory();
    }
}
