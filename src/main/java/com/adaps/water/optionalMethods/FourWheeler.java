package com.adaps.water.optionalMethods;

public interface FourWheeler {

    default void print(){
        System.out.println("I'm a four wheeler!");
    }
}
