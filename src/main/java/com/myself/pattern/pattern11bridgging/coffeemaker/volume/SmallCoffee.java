package com.myself.pattern.pattern11bridgging.coffeemaker.volume;

import com.myself.pattern.pattern11bridgging.coffeemaker.ICoffeeAdditives;
import com.myself.pattern.pattern11bridgging.coffeemaker.RefinedCoffee;

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
