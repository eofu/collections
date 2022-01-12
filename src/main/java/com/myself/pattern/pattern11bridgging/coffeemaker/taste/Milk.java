package com.myself.pattern.pattern11bridgging.coffeemaker.taste;

import com.myself.pattern.pattern11bridgging.coffeemaker.ICoffeeAdditives;

public class Milk implements ICoffeeAdditives {
    @Override
    public void addSomething() {
        System.out.println("Add Milk!");
    }
}
