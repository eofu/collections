package com.myself.pattern.structural.structural4bridgging.coffeemaker.volume;

import com.myself.pattern.structural.structural4bridgging.coffeemaker.ICoffeeAdditives;
import com.myself.pattern.structural.structural4bridgging.coffeemaker.RefinedCoffee;

public class SmallCoffee extends RefinedCoffee {
    public SmallCoffee(ICoffeeAdditives additives) {
        super(additives);
    }
    
    @Override
    public void orderCoffee(int count) {
        additives.addSomething();
        System.out.printf("小杯咖啡%d杯", count);
    }
}
