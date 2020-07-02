package com.designpatterns.adapter;

public class MovableAdapterImpl implements MovableAdapter{

    Movable luxuryCar;

    public MovableAdapterImpl(final Movable luxuryCar){
        this.luxuryCar = luxuryCar;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMH(luxuryCar.getSpeed());
    }

    private double convertMPHtoKMH(double mph){
        return mph * 1.60934;
    }
}
