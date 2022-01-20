package com.myself.pattern.structural.structural4bridgging.coffeemaker.volume;

import com.myself.pattern.structural.structural4bridgging.coffeemaker.ICoffeeAdditives;
import com.myself.pattern.structural.structural4bridgging.coffeemaker.RefinedCoffee;

public class MiddleCoffee extends RefinedCoffee {
    public MiddleCoffee(ICoffeeAdditives additives) {
        super(additives);
    }
    
    @Override
    public void orderCoffee(int count) {
        additives.addSomething();
        System.out.printf("中杯咖啡%d杯", count);
    }
}
