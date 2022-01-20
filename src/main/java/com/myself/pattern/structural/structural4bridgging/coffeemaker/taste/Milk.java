package com.myself.pattern.structural.structural4bridgging.coffeemaker.taste;

import com.myself.pattern.structural.structural4bridgging.coffeemaker.ICoffeeAdditives;

public class Milk implements ICoffeeAdditives {
    @Override
    public void addSomething() {
        System.out.println("Add Milk!");
    }
}
