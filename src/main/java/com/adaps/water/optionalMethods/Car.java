package com.adaps.water.optionalMethods;

public class Car implements Vehicle{

    public void testOptional() {
        //Vehicle.super.print();
        //FourWheeler.super.print();
        //Vehicle.blowFilter();
        System.out.println("I'm a car!");
    }

    @Override
    public void blowFilter() {
        System.out.println("Blow two filters");
    }
}
