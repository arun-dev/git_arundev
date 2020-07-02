package com.designpatterns.abstractfactory;

public interface AbstractFactory<T> {
    T create(String type);
}
