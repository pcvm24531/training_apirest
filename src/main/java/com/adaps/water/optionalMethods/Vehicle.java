package com.adaps.water.optionalMethods;

public interface Vehicle {

    default void print() {
        System.out.println("I'm vehicle!");
    }

    public void blowFilter();
}
