package com.designpatterns.abstractfactory;

public class AnimalFactory implements AbstractFactory<Animal> {
    @Override
    public Animal create(String type) {
        if(type.equals("Dog")){
            return new Dog();
        }
        return new Cat();
    }
}
