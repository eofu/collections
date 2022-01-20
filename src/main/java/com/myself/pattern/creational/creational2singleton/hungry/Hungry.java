package com.myself.pattern.creational.creational2singleton.hungry;

public class Hungry {
    private Hungry() {

    }

    private static final Hungry hungry = new Hungry();

    public static Hungry getHungry() {
        return hungry;
    }
}
