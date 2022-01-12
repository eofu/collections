package com.myself.pattern.pattern11bridgging.coffeemaker.volume;

import com.myself.pattern.pattern11bridgging.coffeemaker.ICoffeeAdditives;
import com.myself.pattern.pattern11bridgging.coffeemaker.RefinedCoffee;

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
